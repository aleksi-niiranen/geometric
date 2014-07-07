(ns geometric.triangle
  (:require [geometric.core :refer :all]
            [geometric.datatypes :refer :all]
            [geometric.utils :refer :all]))

(defmethod perimeter geometric.datatypes.Triangle
  [t]
  (reduce + (take 3 (vals t))))

(defn triangle
  [a b c A B C]
  (with-meta (->Triangle a b c A B C) {:shape :triangle}))

(defn- legs
  "Returns the legs of a triangle."
  [t]
  (take 3 (vals t)))

(defn- angles
  "Returns the angles of a triangle."
  [t]
  (nthnext (vals t) 3))

(defn- pairs-from-set-of-3
  "Returns value pairs from a set of 3."
  [coll]
  (conj (map vector coll (rest coll)) (vector (first coll) (last coll))))

(defn- equal-pairs?
  "Tests if values in pairs are equal and returns a collection of boolean values."
  [coll]
  (map (fn [x] (apply = x)) coll))

(defn equilateral?
  "Test if a triangle is equilateral."
  [t]
  (and (= 60 (:A t) (:B t) (:C t))
       (= (:a t) (:b t) (:c t))))

(defn isosceles?
  "Test if a triangle is isosceles."
  [t]
  (true?
    (and
      (some true? (equal-pairs? (pairs-from-set-of-3 (legs t))))
      (some true? (equal-pairs? (pairs-from-set-of-3 (angles t)))))))

(defn scalene?
  "Test if a triangle is scalene."
  [t]
  (and
    (apply = (equal-pairs? (pairs-from-set-of-3 (legs t))))
    (apply = (equal-pairs? (pairs-from-set-of-3 (angles t))))))

(defn acute?
  "Test if a triangle is acute."
  [t]
  (apply = (map (fn [x] (< x 90)) (angles t))))

(defn right?
  "Test if a triangle is right i.e. has a 90 degree angle."
  [t]
  (if (nil? (some #{90} (angles t))) false true))
