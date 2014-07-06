(ns geometric.datatypes-test
  (:require [clojure.test :refer :all]
            [geometric.datatypes :refer :all]))

(deftest quadrilateral-record
  (testing "Quadrilateral record"
    (let [q (->Quadrilateral 2 5 2 5 45 90 45 90)]
      (testing "sides"
        (is (= 2 (:a q)))
        (is (= 5 (:b q)))
        (is (= 2 (:c q)))
        (is (= 5 (:d q))))
      (testing "angles"
        (is (= 45 (:A q)))
        (is (= 90 (:B q)))
        (is (= 45 (:C q)))
        (is (= 90 (:D q))))
      (testing "type"
        (is (= geometric.datatypes.Quadrilateral (class q)))))))

(deftest circle-record
  (testing "Circle record"
    (let [c (->Circle 5)]
      (is (= 5 (:r c)))
      (is (= geometric.datatypes.Circle (class c))))))

(deftest triangle-record
  (testing "Triangle record"
    (let [t (->Triangle 2 3 4 45 55 80)]
      (testing "sides"
        (is (= 2 (:a t)))
        (is (= 3 (:b t)))
        (is (= 4 (:c t))))
      (testing "angles"
        (is (= 45 (:A t)))
        (is (= 55 (:B t)))
        (is (= 80 (:C t))))
      (testing "type"
        (is (= geometric.datatypes.Triangle (class t)))))))
