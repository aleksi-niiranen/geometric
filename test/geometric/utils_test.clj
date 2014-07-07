(ns geometric.utils-test
  (:require [clojure.test :refer :all]
            [geometric.utils :refer :all]))

(deftest radians-fn
  (testing "radians function"
    (is (== 0.785398 (round (radians 45) 6)))))
