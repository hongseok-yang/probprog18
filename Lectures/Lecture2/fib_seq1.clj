(ns lecture2e)

(defn rev [l] 
  (reduce conj (list) l))

(defn conc [l1 l2]
  (reduce conj l2 (rev l1)))

(defn fib [n]
  (loop [i 2 s (list 1 1)]
    (if (= i n)
      (rev s) 
      (recur (+' i 1)
             (conj s (+' (first s) (second s)))))))

(defn get-digits [n]
  (map (fn [c] (- (int c) (int \0))) (str n)))

(defn ck [fibn-and-i]
  (let [fibn (first fibn-and-i)
        i    (second fibn-and-i)]
    (= (reduce + 0 (get-digits fibn)) i)))

(def idx-fib-seq 
  (map (fn [s i] (list s i)) 
       (fib 10000)
       (range 1 10001)))

(def indices
  (map second (filter ck idx-fib-seq)))
