(ns geometric.triangle
  (:require [geometric.core :refer :all
             geometric.utils :refer :all]))

(defmethod perimeter geometric.datatypes.Triangle
  [t]
  (reduce + (take 3 (vals t))))

(defn equilateral?
  "Test if a triangle is equilateral."
  [t]
  (and (= 60 (:A t) (:B t) (:C t))
       (= (:a t) (:b t) (:c t))))

(defn isosceles?
  "Test if a triangle is isosceles."
  [t]
  )

(defn scalene?
  "Test if a triangle is scalene."
  [t]
  (let [legs (take 3 (vals t))
        angles (nthnext (vals t) 3)
        leg-pairs (conj (map vector legs (rest legs)) (vector (first legs) (last legs)))
        angle-pairs (conj (map vector angles (rest angles)) (vector (first angles) (last angles)))]
    (and
      (apply = (map (fn [x] (apply = x)) leg-pairs))
      (apply = (map (fn [x] (apply = x)) angle-pairs)))))

