(ns record-parser.record-query)

(defn sort-records [records sort-type]
  (case sort-type
    :last (reverse (sort-by :last records))
    (sort-by sort-type records)))
