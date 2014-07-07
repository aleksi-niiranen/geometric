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

(deftest triangle-fn
  (testing "triangle function"
    (let [tfn (triangle 5 6 7 35 55 90)]
      (is (= t tfn))
      (is (= :triangle (shape-meta tfn))))))

(deftest acute?-fn
  (testing "acute? function"
    (is (false? (acute? t)))
    (is (acute? (->Triangle 7 13 9 33 67 80)))))

(deftest right?-fn
  (testing "right? function"
    (is (false? (right? (->Triangle 7 13 9 33 67 80))))
    (is (right? t))))
