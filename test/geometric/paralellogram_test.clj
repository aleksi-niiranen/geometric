(ns geometric.paralellogram-test
  (:require [clojure.test :refer :all]
            [geometric.utils :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.parallelogram :refer :all]))

(def p (with-meta (->Quadrilateral 3 6 3 6 70 110 70 110) {:shape :parallelogram}))

(deftest parallelogram-fn
  (testing "parallelogram function"
    (let [pfn (parallelogram 3 6 70)]
      (is (= p pfn))
      (is (= :parallelogram (shape-meta pfn)))
      (is (paralellogram? pfn)))))

(deftest paralellogram?-fn
  (testing "paralellogram? function"
    (is (true? (paralellogram? p)))
    (is (false? (paralellogram? (->Quadrilateral 4 5 6 7 45 45 135 135))))))

(deftest area-fn
  (testing "area function"
    (is (== 16.9145 (round (area p) 4)))))
