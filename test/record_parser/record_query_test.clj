(ns record-parser.record-query-test
  (:require [record-parser.record-query :refer :all :as record-query]
            [clj-time.coerce :refer [from-string]]
            [clojure.test :refer :all]))

(deftest record-query-test
  (testing "sorts by gender then last name ascending"
    (is (= [{:last "Eastwood" :gender "female"}
            {:last "Zapata" :gender "female"}
            {:last "Abrams" :gender "male"}
            {:last "Bach" :gender "male"}]
           (record-query/sort-records [{:last "Zapata" :gender "female"}
                                       {:last "Bach" :gender "male"}
                                       {:last "Eastwood" :gender "female"}
                                       {:last "Abrams" :gender "male"}
                                       ] :gender))))

  (testing "sorts by last name descending"
    (is (= [{:last "Zapata"} {:last "Abrams"}]
           (record-query/sort-records [{:last "Abrams"} {:last "Zapata"}] :last)))
    (is (= [{:last "Zapata"} {:last "Bach"} {:last "Abrams"}]
           (record-query/sort-records [{:last "Zapata"} {:last "Abrams"} {:last "Bach"}] :last))))
  (testing "sorts by birthdate ascending"
    (is (= [{:birthdate (from-string "1990-01-01")}
            {:birthdate (from-string "1991-01-01")}
            {:birthdate (from-string "1992-01-01")}]
           (record-query/sort-records [{:birthdate (from-string "1990-01-01")}
                                       {:birthdate (from-string "1992-01-01")}
                                       {:birthdate (from-string "1991-01-01")}] :birthdate)))))
