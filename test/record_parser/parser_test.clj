(ns record-parser.parser-test
  (:require [record-parser.parser :refer [parse]]
            [clj-time.coerce :refer [from-string]]
            [clojure.test :refer :all]))

(deftest parser-test
  (testing "parses with comma"
    (is (= {:first "first" :last "last"
            :gender "male" :color "red"
            :birthdate (from-string "1990-01-01")}
           (parse "last, first, male, red, 1990-01-01"))))

  (testing "parses with pipe separator"
    (is (= {:first "first" :last "last"
            :gender "male" :color "red"
            :birthdate (from-string "1990-01-01")}
           (parse "last | first | male | red | 1990-01-01"))))

  (testing "parses with spaces"
    (is (= {:first "first" :last "last"
            :gender "male" :color "red"
            :birthdate (from-string "1990-01-01")}
           (parse "last first male red 1990-01-01")))))
