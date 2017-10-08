(ns bank-ocr.core-test
  (:require [clojure.test :refer :all]
            [bank-ocr.core :refer :all]))

(deftest strip-whitespace-test
  (testing "strips whitespace"
    (is (= (strip-whitespace
"
 _ 
| |
|_|") " _ | ||_|"))))

(deftest read-account-entry-test
  (testing "can read all zeros"
    (is (= read-account-entry "
 _  _  _  _  _  _  _  _  _ 
| || || || || || || || || |
|_||_||_||_||_||_||_||_||_|
                               "
           "0000000000"))))
