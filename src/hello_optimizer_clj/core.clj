(ns hello-optimizer-clj.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(defn bar [x]  
  (+ x 1))

(defn square [x]
  (* x x))

(defn average [x y]
  (/ (+ x y) 2.0))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough [guess x]
  (< (math/abs (- (square guess) x)) 0.001))

(defn new-if [predicate then-clause else-clause]
  (cond
    (boolean? predicate) (then-clause)
    :else (else-clause)))

(defn sqrt-iter [guess x]
  (new-if (good-enough guess x)
      guess
      (sqrt-iter (improve guess x)
                 x)))

(defn square-root [x]
  (sqrt-iter 1.0 x))  

(defn -main
  "Simple optimization."
  [& args]
  (println "bar: "(bar 2))
  (println "square: " (square 2))
  (println "average: " (average 1 3))
  (println "improve: " (improve 5. 3.))
  (println "good-enough: " (good-enough 5. 3.)))
  ; TODO: NA. Finish me.
  ; (println "new-if: ") (new-if (good-enough 5. 3.) (print true) (print false))
  ; (println "new-if: ") (new-if (good-enough 5. 5.00001) (print true) (print true)))  
  ; (println "square-root: " (square-root 3)))