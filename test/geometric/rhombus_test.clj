(ns geometric.rhombus-test
  (:require [clojure.test :refer :all]
            [geometric.utils :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.quadrilateral :refer :all]
            [geometric.rhombus :refer :all]))

(def r (with-meta (->Quadrilateral 5 5 5 5 45 135 45 135) {:shape :rhombus}))

(deftest rhombus-fn
  (testing "rhombus function"
    (let [rfn (rhombus 5 45)]
      (is (= r rfn))
      (is (= :rhombus (shape-meta rfn)))
      (is (rhombus? rfn)))))

(deftest rhombus?-fn
  (testing "rhombus? function"
    (is (true? (rhombus? r)))
    (is (false? (rhombus? (->Quadrilateral 7 9 7 9 45 135 45 135))))))

(deftest diagonal-p-fn
  (testing "diagonal-p function"
    (is (== 9.2388 (round (diagonal-p r) 4)))))

(deftest diagonal-q-fn
  (testing "diagonal-p function"
    (is (== 3.82683 (round (diagonal-q r) 5)))))

(deftest area-fn
  (testing "area function"
    (is (== 17.6777 (round (area r) 4)))))
