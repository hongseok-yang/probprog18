(ns lecture2d)

(defn fib [n]
  (loop [i 2 r0 1 r1 1]
    (if (= i n)
      r1
      (recur (+' i 1)
             r1
             (+' r0 r1)))))
