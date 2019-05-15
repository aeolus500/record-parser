(ns record-parser.command-line.presenter
  (:require [clj-time.format :as f]))

(defn record->string [{first-name :first
                       last-name :last
                       gender :gender
                       color :color
                       birthdate :birthdate}]
  (str first-name " " last-name " " gender " " color " " (f/unparse (f/formatter "MM/dd/yyyy") birthdate)))

(defn present [records]
  (clojure.string/join "\n" (map record->string records)))
