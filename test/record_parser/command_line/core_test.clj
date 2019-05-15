(ns record-parser.command-line.core-test
  (:require
    [record-parser.command-line.core :as core]
    [clojure.test :refer :all]))

(deftest command-line-core-test
  (testing "correctly takes a file and order and prints it out"
    (is (= "else someone female blue 10/13/1992\nlast first male red 1/1/1990\n"
           (with-out-str (core/run "./test/record_parser/support/sample.txt" "gender"))))))
