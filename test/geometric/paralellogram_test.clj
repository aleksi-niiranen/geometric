(ns geometric.paralellogram-test
  (:require [clojure.test :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.quadrilateral :refer :all]
            [geometric.parallelogram :refer :all]))

(def p (with-meta (->Quadrilateral 3 6 3 6 70 110 70 110) {:shape :parallelogram}))

(deftest parallelogram-fn
  (testing "parallelogram function"
    (let [pfn (parallelogram 3 6 70)]
      (is (= p pfn))
      (is (= :parallelogram (shape-meta pfn)))
      (is (paralellogram? pfn)))))
