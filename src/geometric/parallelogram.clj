(ns geometric.parallelogram
  (:require [geometric.core :refer :all]
            [geometric.quadrilateral :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.utils :refer :all]))

(defn parallelogram
  "Returns a new parallelogram."
  [a b A]
  (let [B (/  (- 360 A A) 2)]
    (with-meta (->Quadrilateral a b a b A B A B) {:shape :parallelogram})))

(defmethod area :parallelogram
  [q]
  (let [a (radians (.A q))]
    (* (.a q) (.b q) (sin a))))

(defn paralellogram?
  "Test if a quadrilateral is a parallelogram."
  [q]
  (and (supplementary? q) (= (:a q) (:c q)) (= (:b q) (:d q))))
