(ns geometric.rhombus
  (:require [geometric.core :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.quadrilateral :refer :all]
            [geometric.utils :refer :all]))

(defn rhombus
  "Returns a new rhombus."
  [a A]
  (let [B (/ (- 360 A A) 2)]
    (with-meta (->Quadrilateral a a a a A B A B) {:shape :rhombus})))

(defmethod diagonal-p :rhombus
  [q]
  (let [a (radians (:A q))]
    (* 2 (:a q) (cos (/ a 2)))))

(defmethod diagonal-q :rhombus
  [q]
  (let [a (radians (:A q))]
    (* 2 (:a q) (sin (/ a 2)))))

(defmethod area :rhombus
  [q]
  (/ (* (diagonal-p q) (diagonal-q q)) 2))

(defn rhombus?
  "Test if a quadrilateral is a rhombus."
  [q]
  (and (true? (equal-sides? q)) (true? (supplementary? q))))
