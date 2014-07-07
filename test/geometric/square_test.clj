(ns geometric.square-test
  (:require [clojure.test :refer :all]
            [geometric.utils :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.quadrilateral :refer :all]
            [geometric.square :refer :all]))

(def s (with-meta (->Quadrilateral 6 6 6 6 90 90 90 90) {:shape :square}))

(deftest square-fn
  (testing "square function"
    (let [sfn (square 6)]
      (is (= s sfn))
      (is (= :square (shape-meta sfn)))
      (is (square? sfn)))))

(deftest square?-fn
  (testing "square? function"
    (is (true? (square? s)))
    (is (false? (square? (->Quadrilateral 3 6 3 6 90 90 90 90))))))

(deftest area-fn
  (testing "area function"
    (is (= 36 (area s)))))
