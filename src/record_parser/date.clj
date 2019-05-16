(ns record-parser.date
  (:require
    [clj-time.coerce :refer [from-string]]
    [clj-time.format :as f]))

(defn string->date [string]
  (from-string string))

(defn date->string [date]
  (f/unparse (f/formatter "M/d/yyyy") date))
