(ns record-parser.web.presenter
  (:require [record-parser.date :refer [date->string]]))

(defn present [record]
  (update record :birthdate date->string))
