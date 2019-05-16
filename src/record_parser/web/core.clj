(ns record-parser.web.core
  (:require
    [record-parser.parser :refer [parse]]
    [record-parser.record-query :refer [sort-records]]
    [record-parser.web.presenter :as presenter]
    [ring.util.request :refer [path-info body-string]]
    [ring.util.response :refer [response not-found status]]
    [ring.middleware.json :refer [wrap-json-response]]
    [ring.adapter.jetty :refer [run-jetty]]))

(def records (atom []))

(defmulti router #(identity [(:request-method %) (path-info %)]))

(defmethod router [:post "/records"] [request]
  (do
    (swap! records conj (parse (body-string request)))
    (status (response {:success true}) 201)))

(defmethod router [:get "/records/name"] [request]
  (->> (sort-records @records :last)
       (map presenter/present)
       (response)))

(defmethod router [:get "/records/birthdate"] [request]
  (->> (sort-records @records :birthdate)
       (map presenter/present)
       (response)))

(defmethod router [:get "/records/gender"] [request]
  (->> (sort-records @records :gender)
       (map presenter/present)
       (response)))

(defmethod router :default [request]
  (not-found {}))

(def handler
  (->
    router
    wrap-json-response))

(defn run-server [port]
  (run-jetty handler {:port port}))
