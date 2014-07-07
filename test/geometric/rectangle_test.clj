(ns geometric.rectangle-test
  (:require [clojure.test :refer :all]
            [geometric.utils :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.quadrilateral :refer :all]
            [geometric.rectangle :refer :all]))

(def r (with-meta (->Quadrilateral 3 6 3 6 90 90 90 90) {:shape :rectangle}))

(deftest rectangle-fn
  (testing "rectangle function"
    (let [rfn (rectangle 3 6)]
      (is (= r rfn))
      (is (= :rectangle (shape-meta rfn)))
      (is (rectangle? rfn)))))

(deftest rectangle?-fn
  (testing "rectangle? function"
    (is (true? (rectangle? r)))
    (is (false? (rectangle? (->Quadrilateral 5 5 5 5 45 135 45 135))))))

(deftest area-fn
  (testing "area function"
    (is (= 18 (area r)))))
