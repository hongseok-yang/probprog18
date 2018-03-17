;; gorilla-repl.fileformat = 1

;; **
;;; # 2D physics example from lecture 4
;; **

;; @@
(use 'nstools.ns)

(ns+ bounce-worksheet
     (:like anglican-user.worksheet)
     (:require [org.nfrac.cljbox2d.core :refer [position]])
     (:use [anglican [state 
                      :only [get-predicts 
                             get-log-weight 
                             get-result]]]))

(require '[bounce :refer [create-world
                          show-world-simulation
                          simulate-world
                          display-static-world
                          balls-in-box]] 
         :reload)
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[nil,nil]"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[[nil,nil],nil]"}
;; <=

;; @@
(def bumper-location1 (list))

(show-world-simulation bumper-location1)
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/bumper-location1</span>","value":"#'bounce-worksheet/bumper-location1"},{"type":"html","content":"<span class='clj-unkown'>#object[quil.Applet 0x1625b356 &quot;quil.Applet[panel5,0,0,600x500,layout=java.awt.FlowLayout]&quot;]</span>","value":"#object[quil.Applet 0x1625b356 \"quil.Applet[panel5,0,0,600x500,layout=java.awt.FlowLayout]\"]"}],"value":"[#'bounce-worksheet/bumper-location1,#object[quil.Applet 0x1625b356 \"quil.Applet[panel5,0,0,600x500,layout=java.awt.FlowLayout]\"]]"}
;; <=

;; @@
(def bumper-location2 (list (list -3 6) (list 7 4)))

(show-world-simulation bumper-location2)
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/bumper-location2</span>","value":"#'bounce-worksheet/bumper-location2"},{"type":"html","content":"<span class='clj-unkown'>#object[quil.Applet 0x784c1a64 &quot;quil.Applet[panel1,0,0,600x500,layout=java.awt.FlowLayout]&quot;]</span>","value":"#object[quil.Applet 0x784c1a64 \"quil.Applet[panel1,0,0,600x500,layout=java.awt.FlowLayout]\"]"}],"value":"[#'bounce-worksheet/bumper-location2,#object[quil.Applet 0x784c1a64 \"quil.Applet[panel1,0,0,600x500,layout=java.awt.FlowLayout]\"]]"}
;; <=

;; @@
(def bumper-location-example
  (list (list -3 6) (list 2 5) (list 7 4) (list 12 3)))

(show-world-simulation bumper-location-example)
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/bumper-location-example</span>","value":"#'bounce-worksheet/bumper-location-example"},{"type":"html","content":"<span class='clj-unkown'>#object[quil.Applet 0x2f095c6d &quot;quil.Applet[panel2,0,0,600x500,layout=java.awt.FlowLayout]&quot;]</span>","value":"#object[quil.Applet 0x2f095c6d \"quil.Applet[panel2,0,0,600x500,layout=java.awt.FlowLayout]\"]"}],"value":"[#'bounce-worksheet/bumper-location-example,#object[quil.Applet 0x2f095c6d \"quil.Applet[panel2,0,0,600x500,layout=java.awt.FlowLayout]\"]]"}
;; <=

;; @@
(def example-world
  (create-world bumper-location-example))

(def example-world-final-state 
  (simulate-world example-world))

(balls-in-box example-world-final-state)
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/example-world</span>","value":"#'bounce-worksheet/example-world"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/example-world-final-state</span>","value":"#'bounce-worksheet/example-world-final-state"}],"value":"[#'bounce-worksheet/example-world,#'bounce-worksheet/example-world-final-state]"},{"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"}],"value":"[[#'bounce-worksheet/example-world,#'bounce-worksheet/example-world-final-state],0]"}
;; <=

;; @@
(with-primitive-procedures
  [create-world simulate-world balls-in-box]
  (defquery physics0 []
    (let [n-bumpers 8
          f (fn [] (list 
                     (sample (uniform-continuous -5 14))
                     (sample (uniform-continuous 0 10))))
          bs (repeatedly n-bumpers f)
          w0 (create-world bs)
          w1 (simulate-world w0)
          num-balls (balls-in-box w1)]
      (list num-balls bs))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/physics0</span>","value":"#'bounce-worksheet/physics0"}
;; <=

;; @@
(def lazy-samples0 
  (doquery :importance physics0 []))
(def samples0 
  (map :result (take-nth 100 (take 2000 (drop 1000 lazy-samples0))))) 
(def best-sample0 
  (reduce (fn [acc x] (if (> (first x) (first acc)) x acc)) 
          samples0))
best-sample0
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/lazy-samples0</span>","value":"#'bounce-worksheet/lazy-samples0"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/samples0</span>","value":"#'bounce-worksheet/samples0"}],"value":"[#'bounce-worksheet/lazy-samples0,#'bounce-worksheet/samples0]"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/best-sample0</span>","value":"#'bounce-worksheet/best-sample0"}],"value":"[[#'bounce-worksheet/lazy-samples0,#'bounce-worksheet/samples0],#'bounce-worksheet/best-sample0]"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>9</span>","value":"9"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-0.17861736684488427</span>","value":"-0.17861736684488427"},{"type":"html","content":"<span class='clj-double'>7.972368031428088</span>","value":"7.972368031428088"}],"value":"(-0.17861736684488427 7.972368031428088)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-2.6791342160668377</span>","value":"-2.6791342160668377"},{"type":"html","content":"<span class='clj-double'>4.146746185303478</span>","value":"4.146746185303478"}],"value":"(-2.6791342160668377 4.146746185303478)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-3.845291823400285</span>","value":"-3.845291823400285"},{"type":"html","content":"<span class='clj-double'>6.340513884408622</span>","value":"6.340513884408622"}],"value":"(-3.845291823400285 6.340513884408622)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>4.423826838102673</span>","value":"4.423826838102673"},{"type":"html","content":"<span class='clj-double'>7.228370995042058</span>","value":"7.228370995042058"}],"value":"(4.423826838102673 7.228370995042058)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>5.452516407366196</span>","value":"5.452516407366196"},{"type":"html","content":"<span class='clj-double'>4.092124293263437</span>","value":"4.092124293263437"}],"value":"(5.452516407366196 4.092124293263437)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>8.739433354938486</span>","value":"8.739433354938486"},{"type":"html","content":"<span class='clj-double'>3.2993144616235837</span>","value":"3.2993144616235837"}],"value":"(8.739433354938486 3.2993144616235837)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>1.0919315920688466</span>","value":"1.0919315920688466"},{"type":"html","content":"<span class='clj-double'>2.559094401723454</span>","value":"2.559094401723454"}],"value":"(1.0919315920688466 2.559094401723454)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-3.682197108649204</span>","value":"-3.682197108649204"},{"type":"html","content":"<span class='clj-double'>5.352281704424695</span>","value":"5.352281704424695"}],"value":"(-3.682197108649204 5.352281704424695)"}],"value":"((-0.17861736684488427 7.972368031428088) (-2.6791342160668377 4.146746185303478) (-3.845291823400285 6.340513884408622) (4.423826838102673 7.228370995042058) (5.452516407366196 4.092124293263437) (8.739433354938486 3.2993144616235837) (1.0919315920688466 2.559094401723454) (-3.682197108649204 5.352281704424695))"}],"value":"(9 ((-0.17861736684488427 7.972368031428088) (-2.6791342160668377 4.146746185303478) (-3.845291823400285 6.340513884408622) (4.423826838102673 7.228370995042058) (5.452516407366196 4.092124293263437) (8.739433354938486 3.2993144616235837) (1.0919315920688466 2.559094401723454) (-3.682197108649204 5.352281704424695)))"}],"value":"[[[#'bounce-worksheet/lazy-samples0,#'bounce-worksheet/samples0],#'bounce-worksheet/best-sample0],(9 ((-0.17861736684488427 7.972368031428088) (-2.6791342160668377 4.146746185303478) (-3.845291823400285 6.340513884408622) (4.423826838102673 7.228370995042058) (5.452516407366196 4.092124293263437) (8.739433354938486 3.2993144616235837) (1.0919315920688466 2.559094401723454) (-3.682197108649204 5.352281704424695)))]"}
;; <=

;; @@
(show-world-simulation (first (rest best-sample0)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[quil.Applet 0x40f2a413 &quot;quil.Applet[panel6,0,0,600x500,layout=java.awt.FlowLayout]&quot;]</span>","value":"#object[quil.Applet 0x40f2a413 \"quil.Applet[panel6,0,0,600x500,layout=java.awt.FlowLayout]\"]"}
;; <=

;; @@
(with-primitive-procedures
  [create-world simulate-world balls-in-box]
  (defquery physics1 []
    (let [n-bumpers 8
          f (fn [] (list 
                     (sample (uniform-continuous -5 14))
                     (sample (uniform-continuous 0 10))))
          bs (repeatedly n-bumpers f)
          w0 (create-world bs)
          w1 (simulate-world w0)
          num-balls (balls-in-box w1)]
      (observe (normal num-balls 1) 20)
      (list num-balls bs))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/physics1</span>","value":"#'bounce-worksheet/physics1"}
;; <=

;; @@
(def lazy-samples1 
  (doquery :lmh physics1 []))
(def samples1 
  (map :result (take-nth 100 (take 2000 (drop 1000 lazy-samples1)))))
(def best-sample1 
  (reduce (fn [acc x] (if (> (first x) (first acc)) x acc))
          samples1))
best-sample1
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/lazy-samples1</span>","value":"#'bounce-worksheet/lazy-samples1"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/samples1</span>","value":"#'bounce-worksheet/samples1"}],"value":"[#'bounce-worksheet/lazy-samples1,#'bounce-worksheet/samples1]"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/best-sample1</span>","value":"#'bounce-worksheet/best-sample1"}],"value":"[[#'bounce-worksheet/lazy-samples1,#'bounce-worksheet/samples1],#'bounce-worksheet/best-sample1]"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>18</span>","value":"18"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>10.278954574435122</span>","value":"10.278954574435122"},{"type":"html","content":"<span class='clj-double'>1.2680559222233456</span>","value":"1.2680559222233456"}],"value":"(10.278954574435122 1.2680559222233456)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-1.6660355147359494</span>","value":"-1.6660355147359494"},{"type":"html","content":"<span class='clj-double'>8.38475898872457</span>","value":"8.38475898872457"}],"value":"(-1.6660355147359494 8.38475898872457)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>2.719715303178474</span>","value":"2.719715303178474"},{"type":"html","content":"<span class='clj-double'>4.434110484380998</span>","value":"4.434110484380998"}],"value":"(2.719715303178474 4.434110484380998)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>12.396215872564557</span>","value":"12.396215872564557"},{"type":"html","content":"<span class='clj-double'>1.9902935846748115</span>","value":"1.9902935846748115"}],"value":"(12.396215872564557 1.9902935846748115)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>5.769372990597648</span>","value":"5.769372990597648"},{"type":"html","content":"<span class='clj-double'>4.071537215877996</span>","value":"4.071537215877996"}],"value":"(5.769372990597648 4.071537215877996)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-2.0597441042048126</span>","value":"-2.0597441042048126"},{"type":"html","content":"<span class='clj-double'>2.399532002314304</span>","value":"2.399532002314304"}],"value":"(-2.0597441042048126 2.399532002314304)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-4.847321268832943</span>","value":"-4.847321268832943"},{"type":"html","content":"<span class='clj-double'>3.313681885610673</span>","value":"3.313681885610673"}],"value":"(-4.847321268832943 3.313681885610673)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>13.837204350559018</span>","value":"13.837204350559018"},{"type":"html","content":"<span class='clj-double'>0.582881215251585</span>","value":"0.582881215251585"}],"value":"(13.837204350559018 0.582881215251585)"}],"value":"((10.278954574435122 1.2680559222233456) (-1.6660355147359494 8.38475898872457) (2.719715303178474 4.434110484380998) (12.396215872564557 1.9902935846748115) (5.769372990597648 4.071537215877996) (-2.0597441042048126 2.399532002314304) (-4.847321268832943 3.313681885610673) (13.837204350559018 0.582881215251585))"}],"value":"(18 ((10.278954574435122 1.2680559222233456) (-1.6660355147359494 8.38475898872457) (2.719715303178474 4.434110484380998) (12.396215872564557 1.9902935846748115) (5.769372990597648 4.071537215877996) (-2.0597441042048126 2.399532002314304) (-4.847321268832943 3.313681885610673) (13.837204350559018 0.582881215251585)))"}],"value":"[[[#'bounce-worksheet/lazy-samples1,#'bounce-worksheet/samples1],#'bounce-worksheet/best-sample1],(18 ((10.278954574435122 1.2680559222233456) (-1.6660355147359494 8.38475898872457) (2.719715303178474 4.434110484380998) (12.396215872564557 1.9902935846748115) (5.769372990597648 4.071537215877996) (-2.0597441042048126 2.399532002314304) (-4.847321268832943 3.313681885610673) (13.837204350559018 0.582881215251585)))]"}
;; <=

;; @@
(show-world-simulation (first (rest best-sample1)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[quil.Applet 0x69059e3 &quot;quil.Applet[panel7,0,0,600x500,layout=java.awt.FlowLayout]&quot;]</span>","value":"#object[quil.Applet 0x69059e3 \"quil.Applet[panel7,0,0,600x500,layout=java.awt.FlowLayout]\"]"}
;; <=

;; @@
(with-primitive-procedures
  [create-world simulate-world balls-in-box]
  (defquery physics2 []
    (let [n-bumpers (sample (poisson 6))
          f (fn [] (list 
                     (sample (uniform-continuous -5 14))
                     (sample (uniform-continuous 0 10))))
          bs (repeatedly n-bumpers f)
          w0 (create-world bs)
          w1 (simulate-world w0)
          num-balls (balls-in-box w1)]
      (observe (normal n-bumpers 2) 0)
      (observe (normal num-balls 1) 20)
      (list num-balls bs))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/physics2</span>","value":"#'bounce-worksheet/physics2"}
;; <=

;; @@
(def lazy-samples2 
  (doquery :lmh physics2 []))
(def samples2 
  (map :result (take-nth 100 (take 2000 (drop 1000 lazy-samples2)))))
(defn is-better [x y]
  (let [num-bumpers-less (< (count (second x)) (count (second y)))
        num-balls-more (> (first x) (first y))
        num-balls-equal (= (first x) (first y))
        x-above-threshold (> (first x) 15)
        y-above-threshold (> (first x) 15)]
    (or (and x-above-threshold num-bumpers-less)
        (and num-balls-equal num-bumpers-less)
        num-balls-more)))
(def best-sample2 
  (reduce (fn [acc x] (if (is-better x acc) x acc)) 
          samples2))
best-sample2
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/lazy-samples2</span>","value":"#'bounce-worksheet/lazy-samples2"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/samples2</span>","value":"#'bounce-worksheet/samples2"}],"value":"[#'bounce-worksheet/lazy-samples2,#'bounce-worksheet/samples2]"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/is-better</span>","value":"#'bounce-worksheet/is-better"}],"value":"[[#'bounce-worksheet/lazy-samples2,#'bounce-worksheet/samples2],#'bounce-worksheet/is-better]"},{"type":"html","content":"<span class='clj-var'>#&#x27;bounce-worksheet/best-sample2</span>","value":"#'bounce-worksheet/best-sample2"}],"value":"[[[#'bounce-worksheet/lazy-samples2,#'bounce-worksheet/samples2],#'bounce-worksheet/is-better],#'bounce-worksheet/best-sample2]"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>17</span>","value":"17"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>7.766143204823866</span>","value":"7.766143204823866"},{"type":"html","content":"<span class='clj-double'>0.9367949022731659</span>","value":"0.9367949022731659"}],"value":"(7.766143204823866 0.9367949022731659)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>0.6268248758882189</span>","value":"0.6268248758882189"},{"type":"html","content":"<span class='clj-double'>6.675878881059418</span>","value":"6.675878881059418"}],"value":"(0.6268248758882189 6.675878881059418)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>6.916881084666548</span>","value":"6.916881084666548"},{"type":"html","content":"<span class='clj-double'>9.384445168137942</span>","value":"9.384445168137942"}],"value":"(6.916881084666548 9.384445168137942)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>10.930423472375423</span>","value":"10.930423472375423"},{"type":"html","content":"<span class='clj-double'>3.8260758037107334</span>","value":"3.8260758037107334"}],"value":"(10.930423472375423 3.8260758037107334)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>-2.2750405071785003</span>","value":"-2.2750405071785003"},{"type":"html","content":"<span class='clj-double'>2.3686738336168967</span>","value":"2.3686738336168967"}],"value":"(-2.2750405071785003 2.3686738336168967)"}],"value":"((7.766143204823866 0.9367949022731659) (0.6268248758882189 6.675878881059418) (6.916881084666548 9.384445168137942) (10.930423472375423 3.8260758037107334) (-2.2750405071785003 2.3686738336168967))"}],"value":"(17 ((7.766143204823866 0.9367949022731659) (0.6268248758882189 6.675878881059418) (6.916881084666548 9.384445168137942) (10.930423472375423 3.8260758037107334) (-2.2750405071785003 2.3686738336168967)))"}],"value":"[[[[#'bounce-worksheet/lazy-samples2,#'bounce-worksheet/samples2],#'bounce-worksheet/is-better],#'bounce-worksheet/best-sample2],(17 ((7.766143204823866 0.9367949022731659) (0.6268248758882189 6.675878881059418) (6.916881084666548 9.384445168137942) (10.930423472375423 3.8260758037107334) (-2.2750405071785003 2.3686738336168967)))]"}
;; <=

;; @@
(show-world-simulation (first (rest best-sample2)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[quil.Applet 0x320b3f65 &quot;quil.Applet[panel8,0,0,600x500,layout=java.awt.FlowLayout]&quot;]</span>","value":"#object[quil.Applet 0x320b3f65 \"quil.Applet[panel8,0,0,600x500,layout=java.awt.FlowLayout]\"]"}
;; <=

;; @@

;; @@
