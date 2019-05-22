(ns record-parser.command-line.core
  (:require [record-parser.parser :refer [parse]]
            [record-parser.record-query :as query]
            [record-parser.command-line.presenter :as presenter])
  (:gen-class))

(defn run [[file sort-type]]
  (->
    (slurp file)
    (clojure.string/split #"\n")
    (#(map parse %1))
    (query/sort-records (keyword sort-type))
    (presenter/present)
    (println)))

(defn -main [& args]
  (run args))
