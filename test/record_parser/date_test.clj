(ns record-parser.date-test
  (:require
    [clj-time.core :as t]
    [record-parser.date :refer [date->string string->date]]
    [clojure.test :refer :all]))

(deftest date-test
  (testing "converts a string to a date"
    (is (= 1 (t/month (string->date "2019-01-01"))))
    (is (= 1 (t/day (string->date "2019-01-01"))))
    (is (= 2019 (t/year (string->date "2019-01-01")))))

  (testing "formats a date as a string representation as M/D/YYYY"
    (is (= "1/1/2019" (date->string (string->date "2019-01-01"))))))
