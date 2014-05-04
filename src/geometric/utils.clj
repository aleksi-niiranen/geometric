(ns geometric.utils
  (:require [clojure.math.numeric-tower :as math]))

(def PI (. Math PI))

(defn sqrt
  [x]
  (math/sqrt x))

(defn cos
  [x]
  (. Math cos x))

(defn sin
  [x]
  (. Math sin x))

(defn sqr
  [x]
  (math/expt x 2))

(defn radians
  [a]
  (* a (/ (. Math PI) 180)))

(defn round
  [n s]
  (.setScale (bigdec n) s java.math.RoundingMode/HALF_UP))
