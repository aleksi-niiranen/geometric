(ns geometric.quadrilateral-test
  (:require [clojure.test :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.quadrilateral :refer :all]))

(def legal-q (->Quadrilateral 3 5 3 5 90 90 90 90))
(def lt-360-q (->Quadrilateral 3 4 5 6 45 55 65 75))
(def gt-360-q (->Quadrilateral 3 4 5 6 95 95 95 95))
(def not-q {:a 4 :b 4 :c 4 :d 4 :A 90 :B 90 :C 90 :D 90})

(deftest legal?-fn
  (testing "legal? function"
    (is (legal? legal-q))
    (is (false? (legal? lt-360-q)))
    (is (false? (legal? gt-360-q)))
    (is (false? (legal? not-q)))))

(deftest supplementary?-fn
  (testing "supplementary? function"
    (is (supplementary? legal-q))
    (is (false? (supplementary? lt-360-q)))
    (is (false? (supplementary? gt-360-q)))))

(deftest perimeter-fn
  (testing "perimeter function"
    (is (= 16 (perimeter legal-q)))))

(deftest equal-sides?-fn
  (testing "equal-sides? function"
    (is (false? (equal-sides? legal-q)))
    (is (true? (equal-sides? (->Quadrilateral 4 4 4 4 90 90 90 90))))))

(deftest four-rightangles?-fn
  (testing "four-rightangles? function"
    (is (true? (four-rightangles? legal-q)))
    (is (false? (four-rightangles? (->Quadrilateral 6 10 6 10 100 80 100 80))))))
