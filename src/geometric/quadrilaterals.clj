(ns geometric.quadrilaterals)

(defrecord quadrilateral [a b c d A B C D])

(defn square
  "Returns a new square."
  [x]
  (->quadrilateral x x x x 90 90 90 90)
  )

(defn rectangle
  "Returns a new rectangle."
  [x y]
  (->quadrilateral x y x y 90 90 90 90)
  )

(defn area
  "Counts the area of an object."
  [o]
  (* (.a o) (.b o))
  )

