(ns record-parser.parser
  (:require
    [clj-time.coerce :refer [from-string]]
    [clojure.string :refer [split]]))

(defn parse [line]
  (let [[last first gender color birthdate] (split line #"\s*[\||,|\s]\s*")]
    {:first first
     :last last
     :gender gender
     :color color
     :birthdate (from-string birthdate)}))
