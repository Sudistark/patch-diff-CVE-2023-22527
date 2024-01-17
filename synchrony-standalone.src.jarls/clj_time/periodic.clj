(ns clj-time.periodic
  (:require [clj-time.core :as ct])
  (:import [org.joda.time DateTime ReadablePeriod Period]))

(defn periodic-seq
  "Returns a sequence of date-time values growing over specific period.
  The 2 argument function takes as input the starting value and the growing value,
  returning a lazy infinite sequence.
  The 3 argument function takes as input the starting value, the upper bound value,
  and the growing value, return a lazy sequence."
  ([^DateTime start ^ReadablePeriod period-like]
   (let [^Period period (.toPeriod period-like)]
     (map (fn [i]
            (ct/plus start (.multipliedBy period i)))
          (iterate inc 0))))
  ([^DateTime start ^DateTime end ^ReadablePeriod period-like]
   (let [^Period period (.toPeriod period-like)]
     (take-while (fn [^DateTime next]
                   (ct/before? next end))
                 (periodic-seq start period-like)))))
