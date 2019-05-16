(ns record-parser.web.core-test
  (:require
    [record-parser.web.core :refer :all]
    [ring.mock.request :as mock]
    [cheshire.core :refer :all]
    [clojure.test :refer :all]))

(defn setup [spec]
  (reset! records [])
  (do
    (handler
      (-> (mock/request :post "/records")
          (mock/body "first last male red 1990-01-01")))
    (handler
      (-> (mock/request :post "/records")
          (mock/body "other person female red 1995-01-01"))))
  (spec))

(use-fixtures :each setup)

(deftest web-sort-birthdate
  (testing "can get sorted by birthdate"
    (let [get-result (handler (mock/request :get "/records/birthdate"))]
      (is (= '({:first "last",
                :last "first",
                :gender "male",
                :color "red",
                :birthdate "1/1/1990"}
               {:first "person",
                :last "other",
                :gender "female",
                :color "red",
                :birthdate "1/1/1995"})
             (parse-string (:body get-result) true))))))

(deftest web-sort-last
  (testing "can get sorted by last name"
    (let [get-result (handler (mock/request :get "/records/name"))]
      (is (= '({:first "person",
                :last "other",
                :gender "female",
                :color "red",
                :birthdate "1/1/1995"}
               {:first "last",
                :last "first",
                :gender "male",
                :color "red",
                :birthdate "1/1/1990"})
             (parse-string (:body get-result) true))))))

(deftest web-sort-gender
  (testing "can get sorted by gender"
    (let [get-result (handler (mock/request :get "/records/gender"))]
      (is (= '({:first "person",
                :last "other",
                :gender "female",
                :color "red",
                :birthdate "1/1/1995"}
               {:first "last",
                :last "first",
                :gender "male",
                :color "red",
                :birthdate "1/1/1990"})
             (parse-string (:body get-result) true))))))

(deftest test-post
  (testing "POST returns successfully"
    (is (= 201 (:status (handler
                          (-> (mock/request :post "/records")
                              (mock/body "first last male red 1995-01-01"))))))))
