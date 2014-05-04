(ns geometric.circle
  (:require [geometric.datatypes :refer :all]
            [geometric.core :refer :all]
            [geometric.utils :refer :all]))

(defn circle
  "Returns a new circle."
  [r]
  (with-meta (->Circle r) {:shape :circle}))

(defmethod area :circle
  [c]
  (* PI (sqr (:r c))))

(defmethod perimeter geometric.datatypes.Circle
  [c]
  (* 2 PI (:r c)))

(defn diameter
  [c]
  (* 2 (:r c)))
