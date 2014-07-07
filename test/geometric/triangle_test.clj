(ns geometric.triangle-test
  (:require [clojure.test :refer :all]
            [geometric.utils :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.triangle :refer :all]))

(def t (with-meta (->Triangle 5 6 7 35 55 90) {:shape :triangle}))

(deftest equilateral?-fn
  (testing "equilateral? function"
    (is (equilateral? (->Triangle 6 6 6 60 60 60)))
    (is (false? (equilateral? (->Triangle 6 9 9 40 40 100))))))

(deftest isosceles?-fn
  (testing "isosceles? function"
    (is (false? (isosceles? t)))
    (is (isosceles? (->Triangle 9 9 6 50 50 80)))))

(deftest scalene?-fn
  (testing "scalene? function"
    (is (false? (scalene? (->Triangle 9 9 6 50 50 80))))
    (is (scalene? t))))
