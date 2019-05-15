(ns record-parser.parser-test
  (:require [record-parser.parser :refer [parse]]
            [clojure.test :refer :all]))



(deftest parser-test
  (testing "it parses with comma"
    (is (= {:first "first" :last "last"
            :gender "male" :color "red"
            :birthdate "1990-01-01"}
           (parse "last, first, male, red, 1990-01-01")))))
