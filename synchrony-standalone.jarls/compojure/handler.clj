(ns compojure.handler
  "Functions to create Ring handlers from routes.

  This namespace has been **DEPRECATED** in favor of the [ring-defaults][]
  library.

  [ring-defaults]: https://github.com/ring-clojure/ring-defaults"
  {:deprecated "1.2"}
  (:use [ring.middleware params
                         keyword-params
                         nested-params
                         multipart-params
                         cookies
                         session
                         flash]))

(defn- with-opts [routes middleware opts]
  (if opts
    (middleware routes opts)
    (middleware routes)))

(defn api
  "Create a handler suitable for a web API. This adds the following
  middleware to your routes:

  - wrap-params
  - wrap-nested-params
  - wrap-keyword-params"
  {:deprecated "1.2"}
  [routes]
  (-> routes
      wrap-keyword-params
      wrap-nested-params
      wrap-params))

(defn site
  "Create a handler suitable for a standard website. This adds the
  following middleware to your routes:

  - wrap-session
  - wrap-flash
  - wrap-cookies
  - wrap-multipart-params
  - wrap-params
  - wrap-nested-params
  - wrap-keyword-params

  A map of options may also be provided. These keys are provided:

  :session
  : a map of session middleware options

  :multipart
  : a map of multipart-params middleware options"
  {:deprecated "1.2"
   :arglists '([routes] [routes options])}
  [routes & [opts]]
  (-> (api routes)
      (with-opts wrap-multipart-params (:multipart opts))
      (wrap-flash)
      (with-opts wrap-session (:session opts))))
