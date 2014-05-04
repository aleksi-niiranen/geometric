(ns geometric.core-test
  (:require [clojure.test :refer :all]
            [geometric.core :refer :all]))

(def shape (with-meta {:foo :bar} {:shape :square}))

(deftest shape-meta-fn
  (testing "shape-meta function"
    (is (= :square (shape-meta shape)))))

;(def sq (square 4))
;(def rc (rectangle 3 6))
;(def rh (rhombus 4 45))
;(def supp-qrl (->Quadrilateral 5 5 5 5 60 120 60 120))
;(def illegal-qrl (->Quadrilateral 5 5 5 5 45 90 135 120))
;
;(deftest legal-quadrilateral
;  (testing "is legal quadrilateral"
;    (is (legal? supp-qrl)))
;  (testing "is illegal quadrilateral"
;    (is (false? (legal? illegal-qrl)))))
;
;(deftest right-angles
;  (testing "all angles are right angles"
;    (is (four-rightangles? sq)))
;  (testing "all angles are not right angles"
;    (is (false? (four-rightangles? rh)))))
;
;(deftest equal-sides
;  (testing "all sides are equal"
;    (is (equal-sides? sq)))
;  (testing "all sides are not equal"
;    (is (false? (equal-sides? rc)))))
;
;(deftest square-fn
;  (testing "square function"
;    (testing "returns object of right type"
;      (is (= geometric.datatypes.Quadrilateral (class sq))))
;    (testing "returns a q with equal sides"
;      (is (= 4 (:a sq)))
;      (is (= 4 (:b sq)))
;      (is (= 4 (:c sq)))
;      (is (= 4 (:d sq))))
;    (testing "returns a q with four right angles"
;      (is (= 90 (:A sq)))
;      (is (= 90 (:B sq)))
;      (is (= 90 (:C sq)))
;      (is (= 90 (:D sq))))))
