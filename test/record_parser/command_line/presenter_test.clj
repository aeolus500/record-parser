(ns record-parser.command-line.presenter-test
  (:require [clojure.test :refer :all]
            [record-parser.command-line.presenter :refer [present]]
            [clj-time.coerce :refer [from-string]]))

(deftest presenter-test
  (testing "places a record in a single line"
    (is (= "first last male red 1/1/1990"
           (present [{:first "first"
                      :last "last"
                      :gender "male"
                      :color "red"
                      :birthdate (from-string "1990-01-01")}]))))
  (testing "places multiple records in multiple lines")
  (is (= "first last male red 1/1/1990\nfirst last male red 1/1/1990"
           (present [{:first "first"
                      :last "last"
                      :gender "male"
                      :color "red"
                      :birthdate (from-string "1990-01-01")}
                     {:first "first"
                      :last "last"
                      :gender "male"
                      :color "red"
                      :birthdate (from-string "1990-01-01")}]))))
