(ns geometric.square
  (:require [geometric.datatypes :refer :all
             geometric.core :refer :all
             geometric.quadrilateral :refer :all
             geometric.utils :refer :all]))

(defn square
  "Returns a new square."
  [a]
  (with-meta (->Quadrilateral a a a a 90 90 90 90) {:shape :square}))

(defmethod area :square
  [q]
  (sqr (.a q)))

(defn square?
  "Test if a quadrilateral is a square."
  [q]
  (and (true? (equal-sides? q)) (true? (four-rightangles? q))))
