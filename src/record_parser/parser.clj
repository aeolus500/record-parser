(ns record-parser.parser
  (:require [clojure.string :refer [trim split]]))

(defn parse [arg]
  (let [[last first gender color birthdate] (map trim (split arg #"\||,"))]
    {:first first
     :last last
     :gender gender
     :color color
     :birthdate birthdate}))
