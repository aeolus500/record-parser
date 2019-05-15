(ns record-parser.command-line.presenter
  (:require [clj-time.format :as f]))

(defn record->string [{first-name :first
                       last-name :last
                       gender :gender
                       color :color
                       birthdate :birthdate}]
  (clojure.string/join " " [first-name last-name gender color (f/unparse (f/formatter "M/d/yyyy") birthdate)]))

(defn present [records]
  (clojure.string/join "\n" (map record->string records)))
