(use 'nstools.ns)
(ns+ one-flip 
     (:use [anglican.core :exclude [-main]] 
           [anglican emit runtime stat]) 
     (:gen-class))

(defquery one-flip 
  [outcome] 
  (let [theta (sample (beta 5 3))] 
    (observe (flip theta) outcome) 
    (> theta 0.7)))

(defn -main
  [& args]
  (let [samples (doquery :lmh one-flip [true])]
    (println 
      (frequencies 
        (map :result (take 1000 samples))))))
