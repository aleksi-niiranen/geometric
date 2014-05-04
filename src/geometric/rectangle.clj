(ns geometric.rectangle
  (:require [geometric.core :refer :all
             geometric.quadrilateral :refer :all
             geometric.utils :refer :all]))

(defn rectangle
  "Returns a new rectangle."
  [a b]
  (with-meta (->Quadrilateral a b a b 90 90 90 90) {:shape :rectangle}))

(defmethod area :rectangle
  [q]
  (* (.a q) (.b q)))

(defn rectangle?
  "Test if a quadrilateral is a rectangle."
  [q]
  (four-rightangles? q))
