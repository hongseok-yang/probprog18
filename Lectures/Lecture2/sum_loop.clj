(ns lecture2b)

(defn sq [x] (* x x))

(defn g [n]
  (loop [i n r 0]
    (if (= i 0) 
      r 
      (recur (- i 1) (+ (sq i) r)))))

(defn h [n]
  (reduce + 0.0 (map sq (range 0 (inc n)))))
