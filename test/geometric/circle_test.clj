(ns geometric.circle-test
  (:require [clojure.test :refer :all]
            [geometric.utils :refer [round]]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.circle :refer :all]))

(def c (with-meta (->Circle 5) {:shape :circle}))

(deftest circle-fn
  (testing "circle function"
    (let [cfn (circle 5)]
      (is (= c cfn))
      (is (= :circle (shape-meta cfn))))))

(deftest circle-perimeter
  (testing "circle perimeter method"
    (is (== 31.4159 (round (perimeter c) 4)))))

(deftest circle-area
  (testing "circle area method"
    (is (== 78.5398 (round (area c) 4)))))

(deftest circle-diameter
  (testing "circle diameter function"
    (is (= 10 (diameter c)))))
