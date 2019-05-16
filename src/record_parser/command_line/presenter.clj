(ns record-parser.command-line.presenter
  (:require [record-parser.date :as date]))

(defn record->string [{first-name :first
                       last-name :last
                       gender :gender
                       color :color
                       birthdate :birthdate}]
  (clojure.string/join " " [first-name last-name gender color (date/date->string birthdate)]))

(defn present [records]
  (clojure.string/join "\n" (map record->string records)))
