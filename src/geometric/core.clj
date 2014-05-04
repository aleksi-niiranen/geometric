(ns geometric.core)

(defn shape-meta
  "Returns the value of shape keyword in metadata."
  [s]
  (:shape (meta s)))

(defmulti area shape-meta)

(defmulti perimeter "Calculates the perimeter of a shape." class)

