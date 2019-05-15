(ns record-parser.parser
  (:require [clojure.string :refer [split]]))

(defn parse [line]
  (let [[last first gender color birthdate] (split line #"\s*\|\s*|\s*\,\s*|\s")]
    {:first first
     :last last
     :gender gender
     :color color
     :birthdate birthdate}))
