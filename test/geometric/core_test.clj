(ns geometric.core-test
  (:require [clojure.test :refer :all]
            [geometric.core :refer :all]))

(def shape (with-meta {:foo :bar} {:shape :square}))

(deftest shape-meta-fn
  (testing "shape-meta function"
    (is (= :square (shape-meta shape)))))

