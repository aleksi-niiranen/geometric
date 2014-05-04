(ns geometric.quadrilateral
  (:require [geometric.core :refer :all]))

(defmulti diagonal-p shape-meta)

(defmulti diagonal-q shape-meta)

(defmethod perimeter geometric.datatypes.Quadrilateral
  [q]
  (reduce + (take 4 (vals q))))

(defn- quadrilateral?
  [q]
  (= geometric.datatypes.Quadrilateral (class q)))

(defn legal?
  [q]
  (let [sum-of-angles (reduce + (drop 4 (vals q)))]
    (and (quadrilateral? q) 
         (= 360 sum-of-angles))))

(defn four-rightangles?
  [q]
  (apply = (drop 4 (vals q))))

(defn equal-sides?
  "Test if all sides of a quadrilateral are equal."
  [q]
  (apply = (take 4 (vals q))))

(defn supplementary?
  "Test if adjacent angles of a quadrilateral are supplementary. Returns true if both A/B and C/D are supplementary."
  [q]
  (= (+ (.A q) (.B q)) (+ (.C q) (.D q)) 180))

