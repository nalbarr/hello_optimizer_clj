(ns hello-optimizer-clj.core
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(defn bar
  [x]  
  (+ x 1))

(defn square
  [x]
  (* x x))

(defn average
  [x y]
  (/ (+ x y) 2.0))

(defn improve
  [guess x]
  (average guess (/ x guess)))

(defn good-enough
  [guess x]
  (< (math/abs (- (square guess) x)) 0.001))

(defn new-if
  [predicate then-clause else-clause]
  (if predicate 
    then-clause 
    else-clause))

(defn sqrt-iter
  [guess x]
  (new-if (good-enough guess x)
      guess
      (sqrt-iter (improve guess x) x)))

(defn square-root
  [x]
  (sqrt-iter 1.0 x))

(defn then-clause
  [x]
  (print "then: " + x)
  x)  

(defn else-clause
  [y]
  (print "else: " + y)
  y)  


(defn -main
  "Simple optimization."
  [& args]

  (println "square: " (square 2))

  (println "average: " (average 1 3))
  
  (println "improve: " (improve 4. 3.))

  (println "good-enough: " (good-enough 4. 3.))

  (println "new-if: "
    (new-if 
      (good-enough 4. 3.);      false
      (then-clause 123)
      (else-clause 345 )))

  (println "new-if: "
    (new-if 
      (good-enough 4. 2.00001);   true
      (then-clause 123)
      (else-clause 345 )))

  ; TODO: NA. Finish me.
  ; - issue with sqrt-iter
  ;(println "square-root: " (square-root 3)))