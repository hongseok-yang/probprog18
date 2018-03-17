;; gorilla-repl.fileformat = 1

;; **
;;; # Fruit-Bin puzzl from Lecture 3
;; **

;; @@
(use 'nstools.ns)
(ns+ template
  (:like anglican-user.worksheet))
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[nil,nil]"}
;; <=

;; @@
(defquery puzl [fruit]
  (let [bin (sample 
              (categorical
                {:red (/ 1 6),
                 :blue (/ 5 6)}))]
    (if (= bin :red)
      (observe (categorical
                 {:apple (/ 2 8),
                  :orange (/ 6 8)})
               fruit)
      (observe (categorical
                 {:apple (/ 3 4),
                  :orange (/ 1 4)})
               fruit))
    bin))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;template/puzl</span>","value":"#'template/puzl"}
;; <=

;; @@
(def samples 
  (take 10000
        (doquery :importance puzl [:orange])))

(defn f [m] (exp (:log-weight m)))
(defn g [m] 
  (if (= (:result m) :blue) (f m) 0.0))

(/ (reduce + 0.0 (map g samples))
   (reduce + 0.0 (map f samples)))
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;template/samples</span>","value":"#'template/samples"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/f</span>","value":"#'template/f"}],"value":"[#'template/samples,#'template/f]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/g</span>","value":"#'template/g"}],"value":"[[#'template/samples,#'template/f],#'template/g]"},{"type":"html","content":"<span class='clj-double'>0.6332728921124207</span>","value":"0.6332728921124207"}],"value":"[[[#'template/samples,#'template/f],#'template/g],0.6332728921124207]"}
;; <=

;; @@
(float (/ 5 8))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>0.625</span>","value":"0.625"}
;; <=
