(ns manifold.time
  {:author "Zach Tellman"
   :doc    "This namespace contains methods for converting units of time, with milliseconds as the base representation, and for deferring execution of functions to some time in the future.  In practice, the methods here are not necessary to use Manifold effectively - `manifold.deferred/timeout` and `manifold.stream/periodically` are more directly useful - but they are available for anyone who should need them."}
  (:require
    [clojure.tools.logging :as log]
    [manifold.executor :as ex]
    [clojure.string :as str]
    [manifold.utils :refer [definterface+ defprotocol+]])
  (:import
    [java.util
     Calendar
     TimeZone]
    [java.util.concurrent
     Future
     Executor
     Executors
     TimeUnit
     ScheduledExecutorService
     ScheduledThreadPoolExecutor
     TimeoutException]))

(defn nanoseconds
  "Converts nanoseconds -> milliseconds"
  [n]
  (/ n 1e6))

(defn microseconds
  "Converts microseconds -> milliseconds"
  [n]
  (/ n 1e3))

(defn milliseconds
  "Converts milliseconds -> milliseconds"
  [n]
  n)

(defn seconds
  "Converts seconds -> milliseconds"
  [n]
  (* n 1e3))

(defn minutes
  "Converts minutes -> milliseconds"
  [n]
  (* n 6e4))

(defn hours
  "Converts hours -> milliseconds"
  [n]
  (* n 36e5))

(defn days
  "Converts days -> milliseconds"
  [n]
  (* n 864e5))

(defn hz
  "Converts frequency -> period in milliseconds"
  [n]
  (/ 1e3 n))

(let [intervals (partition 2 ["d" (days 1)
                              "h" (hours 1)
                              "m" (minutes 1)
                              "s" (seconds 1)])]

  (defn format-duration
    "Takes a duration in milliseconds, and returns a formatted string
     describing the interval, i.e. '5d 3h 1m'"
    [n]
    (loop [s "", n n, intervals intervals]
      (if (empty? intervals)
        (if (empty? s)
          "0s"
          (str/trim s))
        (let [[desc val] (first intervals)]
          (if (>= n val)
            (recur
              (str s (int (/ n val)) desc " ")
              (rem n val)
              (rest intervals))
            (recur s n (rest intervals))))))))

(let [sorted-units         [:millisecond Calendar/MILLISECOND
                            :second Calendar/SECOND
                            :minute Calendar/MINUTE
                            :hour Calendar/HOUR
                            :day Calendar/DAY_OF_YEAR
                            :week Calendar/WEEK_OF_MONTH
                            :month Calendar/MONTH]
      unit->calendar-unit  (apply hash-map sorted-units)
      units                (->> sorted-units (partition 2) (map first))
      unit->cleared-fields (zipmap
                             units
                             (map
                               #(->> (take % units) (map unit->calendar-unit))
                               (range (count units))))]

  (defn floor
    "Takes a `timestamp`, and rounds it down to the nearest even multiple of the `unit`.

         (floor 1001 :second) => 1000
         (floor (seconds 61) :minute) => 60000

     "
    [timestamp unit]
    (assert (contains? unit->calendar-unit unit))
    (let [^Calendar cal (doto (Calendar/getInstance (TimeZone/getTimeZone "UTC"))
                          (.setTimeInMillis timestamp))]
      (doseq [field (unit->cleared-fields unit)]
        (.set cal field 0))
      (.getTimeInMillis cal)))

  (defn add
    "Takes a `timestamp`, and adds `value` multiples of `unit` to the value."
    [timestamp value unit]
    (assert (contains? unit->calendar-unit unit))
    (let [^Calendar cal (doto (Calendar/getInstance (TimeZone/getTimeZone "UTC"))
                          (.setTimeInMillis timestamp))]
      (.add cal (unit->calendar-unit unit) value)
      (.getTimeInMillis cal))))

;;;

(in-ns 'manifold.deferred)
(clojure.core/declare success! error! deferred realized? chain connect)
(in-ns 'manifold.time)

;;;

(definterface+ IClock
  (in [^double interval-millis ^Runnable f])
  (every [^double delay-millis ^double period-millis ^Runnable f]))

(defprotocol+ IMockClock
  (now [clock] "Returns the current time for the clock")
  (advance [clock time]
    "Advances the mock clock by the specified interval of `time`.

    Advancing the clock is a continuous action - the clock doesn't just jump
    from `now` to `new-now = (+ (now clock) time)`. Rather, for each scheduled
    event within `[now; new-now]` the clock is reset to the time of the event
    and the event function is executed.

    For example, if you have a periodic function scheduled with

      (every 1 #(swap! counter inc))

    and advance the clock by 5, the counter will be incremented 6 times in
    total: once initially, as the initial delay is 0 and 5 times for every 1 ms
    step of the clock."))

(defn- cancel-on-exception [f cancel-fn]
  (fn []
    (try (f)
         (catch Throwable t
           (cancel-fn)
           (throw t)))))

(defn scheduled-executor->clock [^ScheduledExecutorService e]
  (reify IClock
    (in [_ interval-millis f]
      (let [^Future scheduled-future (.schedule e f (long (* interval-millis 1e3)) TimeUnit/MICROSECONDS)
            cancel-fn                (fn []
                                       (.cancel scheduled-future false))]
        cancel-fn))
    (every [_ delay-millis period-millis f]
      (let [future-ref (promise)
            cancel-fn  (fn []
                         (let [^Future future @future-ref]
                           (.cancel future false)))]
        (deliver future-ref
                 (.scheduleAtFixedRate e
                                       ^Runnable (cancel-on-exception f cancel-fn)
                                       (long (* delay-millis 1e3))
                                       (long (* period-millis 1e3))
                                       TimeUnit/MICROSECONDS))
        cancel-fn))))

(defn mock-clock
  "Creates a clock designed for testing scheduled behaviors.  It can replace the default
   scheduler using `with-clock`, and can be advanced to a particular time via `advance`.  By
   default, the initial time is `0`."
  ([]
   (mock-clock 0))
  ([initial-time]
   (let [now    (atom initial-time)
         events (atom (sorted-map))]
     (reify
       IClock
       (in [this interval-millis f]
         (swap! events update-in [(+ @now interval-millis)] #(conj (or % []) f))
         (advance this 0))
       (every [this delay-millis period-millis f]
         (assert (< 0 period-millis))
         (let [period    (atom period-millis)
               cancel-fn #(reset! period -1)]
           (->> (with-meta (cancel-on-exception f cancel-fn) {::period period})
                (.in this (max 0 delay-millis)))
           cancel-fn))

       IMockClock
       (now [_] @now)
       (advance
         [this time]
         (let [limit (+ @now time)]
           (loop []
             (if (or (empty? @events)
                     (< limit (key (first @events))))
               (do
                 (reset! now limit)
                 nil)

               (let [[t fs] (first @events)]
                 (swap! events dissoc t)
                 (reset! now t)
                 (doseq [f fs]
                   (let [period (some-> f meta ::period deref)]
                     (when (or (nil? period) (pos? period))
                       (try
                         (f)
                         (when period (.in this period f))
                         (catch Throwable e
                           (log/debug e "error in mock clock"))))))
                 (recur))))))))))

(let [num-cores (.availableProcessors (Runtime/getRuntime))
      cnt       (atom 0)
      clock     (delay
                  (scheduled-executor->clock
                    (doto (ScheduledThreadPoolExecutor.
                            1
                            (ex/thread-factory
                              (fn []
                                (str "manifold-scheduler-pool-" (swap! cnt inc)))
                              (deliver (promise) nil)))
                      (.setRemoveOnCancelPolicy true))))]
  (def ^:dynamic ^IClock *clock*
    (reify IClock
      (in [_ interval f] (.in ^IClock @clock interval f))
      (every [_ delay period f] (.every ^IClock @clock delay period f)))))

(defmacro with-clock
  "Ensures that all calls to `every` and `in` are made through the specified clock, rather
   than the default one."
  [clock & body]
  `(binding [*clock* ~clock]
     ~@body))

(defn in
  "Schedules no-arg function `f` to be invoked in `interval` milliseconds.  Returns a deferred
   representing the returned value of the function (unwrapped if `f` itself returns a deferred).
   If the returned deferred is completed before the interval has passed, the timeout function
   will be cancelled."
  [^double interval f]
  (let [d         (manifold.deferred/deferred)
        f         (fn []
                    (when-not (manifold.deferred/realized? d)
                      (try
                        (manifold.deferred/connect (f) d)
                        (catch Throwable e
                          (manifold.deferred/error! d e)))))
        cancel-fn (.in *clock* interval f)]
    (manifold.deferred/chain d (fn [_] (cancel-fn)))
    d))

(defn every
  "Schedules no-arg function `f` to be invoked every `period` milliseconds, after `initial-delay`
   milliseconds, which defaults to `0`.  Returns a zero-argument function which, when invoked,
   cancels the repeated invocation.

   If the invocation of `f` ever throws an exception, repeated invocation is automatically
   cancelled."
  ([period f]
   (every period 0 f))
  ([period initial-delay f]
   (.every *clock* initial-delay period f)))

(defn at
  "Schedules no-arg function `f` to be invoked at `timestamp`, which is the milliseconds
   since the epoch.  Returns a deferred representing the returned value of the function
   (unwrapped if `f` itself returns a deferred)."
  [timestamp f]
  (in (max 0 (- timestamp (System/currentTimeMillis))) f))
