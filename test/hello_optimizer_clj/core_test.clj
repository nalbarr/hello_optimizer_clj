(ns hello-optimizer-clj.core-test
  (:require [clojure.test :refer :all]
            [hello-optimizer-clj.core :refer :all]))

(deftest square-2
  (testing "square of 2 is 4."
    (is (= 4 ) (square 2))))

(deftest average-1-and-3
  (testing "average of 1 and 3 is 2."
    (is (= 2 ) (average 1 3))))

(deftest improve-5-and-3
  (testing "improve-guess 5 and 3 is 2.8"
    (is (= 2.8 ) (improve 5. 3.))))

(deftest good-enough-5-and-3
  (testing "good-enough 5 and 3 is false"
    (is (= false ) (good-enough 5. 3.))))

(deftest good-enough-5-and-5_00001
  (testing "good-enough 5 and 5.00001 is false"
    (is (= true ) (good-enough 5. 3.))))

(defn predicate-true
  [x]
  (= 1 1)); always true

(defn predicate-false
  [x]
  (= 2 1)); always false
  
(deftest new-if-predicate-true
  (testing "new-if is true"
    (is (= 123)
      (new-if (predicate-true 1)
        (then-clause 123) 
        (else-clause 345)))))

(deftest new-if-predicate-false
  (testing "new-if is false"
    (is (= 345)
      (new-if (predicate-false 1)
        (then-clause 123) 
        (else-clause 345)))))          
