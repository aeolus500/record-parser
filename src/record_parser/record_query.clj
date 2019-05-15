(ns record-parser.record-query)

(defn- sort-gender [records]
  (let [{female "female" male "male"} (group-by :gender records)]
    (concat (sort-by :last female) (sort-by :last male))))

(defn sort-records [records sort-type]
  (case sort-type
    :gender (sort-gender records)
    :last (reverse (sort-by :last records))
    (sort-by sort-type records)))
