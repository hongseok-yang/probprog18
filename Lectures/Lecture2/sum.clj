(ns lecture2)

(defn sq [x] (* x x))

(defn g [n]
  (if (= n 0) 
    0
    (+ (sq n) (g (- n 1)))))

