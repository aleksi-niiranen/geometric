(ns geometric.quadrilaterals)

(defrecord quadrilateral [a b c d A B C D])

(defn square
  "Returns a new square."
  [a]
  (->quadrilateral a a a a 90 90 90 90))

(defn rectangle
  "Returns a new rectangle."
  [a b]
  (->quadrilateral a b a b 90 90 90 90))

(defn rhombus
  "Returns a new rhombus."
  [a]
  (->quadrilateral a a a a))

(defn perimeter
  "Calculates the perimeter of a quadrilateral."
  [q]
  (reduce + (take 4 (vals q))))

(defn area
  "Counts the area of an object."
  [o]
  (* (.a o) (.b o)))

