;; gorilla-repl.fileformat = 1

;; **
;;; # Random Fibonacci Number Example from Lecture 2
;; **

;; @@
(use 'nstools.ns)
(ns+ template
  (:like anglican-user.worksheet))
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[nil,nil]"}
;; <=

;; **
;;; During the lecture, I explained how to write an Anglican query using the following very simple program.
;; **

;; @@
(defquery baby_rfib [n]
  (let [b     (sample (flip 0.5))
        new-n (if b n (+' n 1))]
    (loop [i  2 
           r0 1
           r1 1]
      (if (= i new-n)
        r1
        (recur (+ i 1)
               r1
               (+' r0 r1))))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;template/baby_rfib</span>","value":"#'template/baby_rfib"}
;; <=

;; **
;;; Before proceeding, let's use Anglican a little bit. We generate samples from the above Anglican query using the importance sampling algorithm. Then, we compute their mean, and compare it against the average of two corresponding fibonacci numbers.
;; **

;; @@
(def M 20)
(def samples_baby_rfib 
  (let [s (doquery :importance baby_rfib [M])]
    (map :result (take 1000 s))))

(def estimate_mean (float (mean samples_baby_rfib)))

(defn fib [n]
  (loop [i  2
         r0 1 
         r1 1]    
    (if (= i n)
      r1
      (recur (+ i 1)
             r1
             (+' r0 r1)))))

(def true_mean (mean [(fib M) (fib (+ M 1))]))

(print (- estimate_mean true_mean))
;; @@
;; ->
;;; 112.88671875
;; <-
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;template/M</span>","value":"#'template/M"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/samples_baby_rfib</span>","value":"#'template/samples_baby_rfib"}],"value":"[#'template/M,#'template/samples_baby_rfib]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/estimate_mean</span>","value":"#'template/estimate_mean"}],"value":"[[#'template/M,#'template/samples_baby_rfib],#'template/estimate_mean]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/fib</span>","value":"#'template/fib"}],"value":"[[[#'template/M,#'template/samples_baby_rfib],#'template/estimate_mean],#'template/fib]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/true_mean</span>","value":"#'template/true_mean"}],"value":"[[[[#'template/M,#'template/samples_baby_rfib],#'template/estimate_mean],#'template/fib],#'template/true_mean]"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[[[[[#'template/M,#'template/samples_baby_rfib],#'template/estimate_mean],#'template/fib],#'template/true_mean],nil]"}
;; <=

;; **
;;; Now we implement the random Fibonacci sequence from the lecture.
;; **

;; @@
(defquery rfib [n]
  (loop [i  2
         r0 1
         r1 1]
    (if (= i n)
      r1
      (let [b  (sample (flip 0.5))
            r2 (if b (+' r1 r0) (-' r1 r0))]
        (recur (+ i 1)
               r1 
               r2)))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;template/rfib</span>","value":"#'template/rfib"}
;; <=

;; **
;;; 
;;; 
;; **

;; **
;;; We draw samples from the above Anglican query.
;; **

;; @@
(def M 70)
(def N 1000)

(def samples_rfib 
  (let [s (doquery :importance rfib [M])]
    (map :result (take N s))))

(plot/histogram samples_rfib
                :bins 50
                :normalize :probability)
;; @@
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;template/M</span>","value":"#'template/M"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/N</span>","value":"#'template/N"}],"value":"[#'template/M,#'template/N]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/samples_rfib</span>","value":"#'template/samples_rfib"}],"value":"[[#'template/M,#'template/N],#'template/samples_rfib]"},{"type":"vega","content":{"width":400,"height":247.2187957763672,"padding":{"top":10,"left":55,"bottom":40,"right":10},"data":[{"name":"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2","values":[{"x":-15578519,"y":0},{"x":-14912959.24,"y":0.001},{"x":-14247399.48,"y":0},{"x":-13581839.72,"y":0.001},{"x":-12916279.96,"y":0.001},{"x":-12250720.200000001,"y":0},{"x":-11585160.440000001,"y":0},{"x":-10919600.680000002,"y":0},{"x":-10254040.920000002,"y":0},{"x":-9588481.160000002,"y":0.001},{"x":-8922921.400000002,"y":0},{"x":-8257361.640000002,"y":0},{"x":-7591801.880000003,"y":0},{"x":-6926242.120000003,"y":0},{"x":-6260682.360000003,"y":0},{"x":-5595122.600000003,"y":0},{"x":-4929562.840000004,"y":0.002},{"x":-4264003.080000004,"y":0},{"x":-3598443.3200000036,"y":0.001},{"x":-2932883.5600000033,"y":0.002},{"x":-2267323.800000003,"y":0.001},{"x":-1601764.0400000028,"y":0},{"x":-936204.2800000027,"y":0.006},{"x":-270644.5200000026,"y":0.016},{"x":394915.23999999755,"y":0.933},{"x":1060474.9999999977,"y":0.015},{"x":1726034.759999998,"y":0.008},{"x":2391594.519999998,"y":0.004},{"x":3057154.2799999984,"y":0.004},{"x":3722714.0399999986,"y":0},{"x":4388273.799999999,"y":0},{"x":5053833.559999999,"y":0},{"x":5719393.319999998,"y":0},{"x":6384953.079999998,"y":0.001},{"x":7050512.839999998,"y":0},{"x":7716072.599999998,"y":0},{"x":8381632.359999998,"y":0},{"x":9047192.119999997,"y":0},{"x":9712751.879999997,"y":0},{"x":10378311.639999997,"y":0},{"x":11043871.399999997,"y":0},{"x":11709431.159999996,"y":0.001},{"x":12374990.919999996,"y":0},{"x":13040550.679999996,"y":0},{"x":13706110.439999996,"y":0.001},{"x":14371670.199999996,"y":0},{"x":15037229.959999995,"y":0},{"x":15702789.719999995,"y":0},{"x":16368349.479999995,"y":0},{"x":17033909.239999995,"y":0},{"x":17699468.999999996,"y":0},{"x":18365028.759999998,"y":0.001},{"x":19030588.52,"y":0}]}],"marks":[{"type":"line","from":{"data":"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"interpolate":{"value":"step-before"},"fill":{"value":"steelblue"},"fillOpacity":{"value":0.4},"stroke":{"value":"steelblue"},"strokeWidth":{"value":2},"strokeOpacity":{"value":1}}}}],"scales":[{"name":"x","type":"linear","range":"width","zero":false,"domain":{"data":"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2","field":"data.x"}},{"name":"y","type":"linear","range":"height","nice":true,"zero":false,"domain":{"data":"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2","field":"data.y"}}],"axes":[{"type":"x","scale":"x"},{"type":"y","scale":"y"}]},"value":"#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 55, :bottom 40, :right 10}, :data [{:name \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\", :values ({:x -1.5578519E7, :y 0} {:x -1.491295924E7, :y 0.001} {:x -1.424739948E7, :y 0.0} {:x -1.358183972E7, :y 0.001} {:x -1.291627996E7, :y 0.001} {:x -1.2250720200000001E7, :y 0.0} {:x -1.1585160440000001E7, :y 0.0} {:x -1.0919600680000002E7, :y 0.0} {:x -1.0254040920000002E7, :y 0.0} {:x -9588481.160000002, :y 0.001} {:x -8922921.400000002, :y 0.0} {:x -8257361.640000002, :y 0.0} {:x -7591801.880000003, :y 0.0} {:x -6926242.120000003, :y 0.0} {:x -6260682.360000003, :y 0.0} {:x -5595122.600000003, :y 0.0} {:x -4929562.840000004, :y 0.002} {:x -4264003.080000004, :y 0.0} {:x -3598443.3200000036, :y 0.001} {:x -2932883.5600000033, :y 0.002} {:x -2267323.800000003, :y 0.001} {:x -1601764.0400000028, :y 0.0} {:x -936204.2800000027, :y 0.006} {:x -270644.5200000026, :y 0.016} {:x 394915.23999999755, :y 0.933} {:x 1060474.9999999977, :y 0.015} {:x 1726034.759999998, :y 0.008} {:x 2391594.519999998, :y 0.004} {:x 3057154.2799999984, :y 0.004} {:x 3722714.0399999986, :y 0.0} {:x 4388273.799999999, :y 0.0} {:x 5053833.559999999, :y 0.0} {:x 5719393.319999998, :y 0.0} {:x 6384953.079999998, :y 0.001} {:x 7050512.839999998, :y 0.0} {:x 7716072.599999998, :y 0.0} {:x 8381632.359999998, :y 0.0} {:x 9047192.119999997, :y 0.0} {:x 9712751.879999997, :y 0.0} {:x 1.0378311639999997E7, :y 0.0} {:x 1.1043871399999997E7, :y 0.0} {:x 1.1709431159999996E7, :y 0.001} {:x 1.2374990919999996E7, :y 0.0} {:x 1.3040550679999996E7, :y 0.0} {:x 1.3706110439999996E7, :y 0.001} {:x 1.4371670199999996E7, :y 0.0} {:x 1.5037229959999995E7, :y 0.0} {:x 1.5702789719999995E7, :y 0.0} {:x 1.6368349479999995E7, :y 0.0} {:x 1.7033909239999995E7, :y 0.0} {:x 1.7699468999999996E7, :y 0.0} {:x 1.8365028759999998E7, :y 0.001} {:x 1.903058852E7, :y 0})}], :marks [{:type \"line\", :from {:data \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :interpolate {:value \"step-before\"}, :fill {:value \"steelblue\"}, :fillOpacity {:value 0.4}, :stroke {:value \"steelblue\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 1}}}}], :scales [{:name \"x\", :type \"linear\", :range \"width\", :zero false, :domain {:data \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\", :field \"data.x\"}} {:name \"y\", :type \"linear\", :range \"height\", :nice true, :zero false, :domain {:data \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}]}}"}],"value":"[[[#'template/M,#'template/N],#'template/samples_rfib],#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 55, :bottom 40, :right 10}, :data [{:name \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\", :values ({:x -1.5578519E7, :y 0} {:x -1.491295924E7, :y 0.001} {:x -1.424739948E7, :y 0.0} {:x -1.358183972E7, :y 0.001} {:x -1.291627996E7, :y 0.001} {:x -1.2250720200000001E7, :y 0.0} {:x -1.1585160440000001E7, :y 0.0} {:x -1.0919600680000002E7, :y 0.0} {:x -1.0254040920000002E7, :y 0.0} {:x -9588481.160000002, :y 0.001} {:x -8922921.400000002, :y 0.0} {:x -8257361.640000002, :y 0.0} {:x -7591801.880000003, :y 0.0} {:x -6926242.120000003, :y 0.0} {:x -6260682.360000003, :y 0.0} {:x -5595122.600000003, :y 0.0} {:x -4929562.840000004, :y 0.002} {:x -4264003.080000004, :y 0.0} {:x -3598443.3200000036, :y 0.001} {:x -2932883.5600000033, :y 0.002} {:x -2267323.800000003, :y 0.001} {:x -1601764.0400000028, :y 0.0} {:x -936204.2800000027, :y 0.006} {:x -270644.5200000026, :y 0.016} {:x 394915.23999999755, :y 0.933} {:x 1060474.9999999977, :y 0.015} {:x 1726034.759999998, :y 0.008} {:x 2391594.519999998, :y 0.004} {:x 3057154.2799999984, :y 0.004} {:x 3722714.0399999986, :y 0.0} {:x 4388273.799999999, :y 0.0} {:x 5053833.559999999, :y 0.0} {:x 5719393.319999998, :y 0.0} {:x 6384953.079999998, :y 0.001} {:x 7050512.839999998, :y 0.0} {:x 7716072.599999998, :y 0.0} {:x 8381632.359999998, :y 0.0} {:x 9047192.119999997, :y 0.0} {:x 9712751.879999997, :y 0.0} {:x 1.0378311639999997E7, :y 0.0} {:x 1.1043871399999997E7, :y 0.0} {:x 1.1709431159999996E7, :y 0.001} {:x 1.2374990919999996E7, :y 0.0} {:x 1.3040550679999996E7, :y 0.0} {:x 1.3706110439999996E7, :y 0.001} {:x 1.4371670199999996E7, :y 0.0} {:x 1.5037229959999995E7, :y 0.0} {:x 1.5702789719999995E7, :y 0.0} {:x 1.6368349479999995E7, :y 0.0} {:x 1.7033909239999995E7, :y 0.0} {:x 1.7699468999999996E7, :y 0.0} {:x 1.8365028759999998E7, :y 0.001} {:x 1.903058852E7, :y 0})}], :marks [{:type \"line\", :from {:data \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :interpolate {:value \"step-before\"}, :fill {:value \"steelblue\"}, :fillOpacity {:value 0.4}, :stroke {:value \"steelblue\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 1}}}}], :scales [{:name \"x\", :type \"linear\", :range \"width\", :zero false, :domain {:data \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\", :field \"data.x\"}} {:name \"y\", :type \"linear\", :range \"height\", :nice true, :zero false, :domain {:data \"d6a002d3-5fc8-4b0c-a2b3-0f0471b063a2\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}]}}]"}
;; <=

;; @@
(defn compute_mean [xs]
  (/ (reduce +' 0.0 xs)
     (count xs)))

(defn compute_var [xs]
  (let [m  (compute_mean xs)
        f  (fn [x] (Math/pow (-' x m) 2))
        ys (map f xs)]
    (compute_mean ys)))

(def mean_est (compute_mean samples_rfib))
(def variance_est (compute_var samples_rfib))

(println "mean: " mean_est)
(println "variance: " variance_est)
(println)

(defn abs_then_nroot [x]
  (exp (/ (log (abs (float x))) M)))
(def samples_rfib_processed
  (map abs_then_nroot samples_rfib))
(def mean_vs_est 
  (compute_mean samples_rfib_processed))
(def variance_vs_est
  (compute_var samples_rfib_processed))

(println "vs mean: " mean_vs_est)
(println "vs variance: " variance_vs_est)
;; @@
;; ->
;;; mean:  1230.99
;;; variance:  1.5399278371324597E12
;;; 
;;; vs mean:  1.1274577736503875
;;; vs variance:  0.002205891542566628
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"list-like","open":"","close":"","separator":"</pre><pre>","items":[{"type":"html","content":"<span class='clj-var'>#&#x27;template/compute_mean</span>","value":"#'template/compute_mean"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/compute_var</span>","value":"#'template/compute_var"}],"value":"[#'template/compute_mean,#'template/compute_var]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/mean_est</span>","value":"#'template/mean_est"}],"value":"[[#'template/compute_mean,#'template/compute_var],#'template/mean_est]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/variance_est</span>","value":"#'template/variance_est"}],"value":"[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est]"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil]"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil]"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil],nil]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/abs_then_nroot</span>","value":"#'template/abs_then_nroot"}],"value":"[[[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil],nil],#'template/abs_then_nroot]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/samples_rfib_processed</span>","value":"#'template/samples_rfib_processed"}],"value":"[[[[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil],nil],#'template/abs_then_nroot],#'template/samples_rfib_processed]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/mean_vs_est</span>","value":"#'template/mean_vs_est"}],"value":"[[[[[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil],nil],#'template/abs_then_nroot],#'template/samples_rfib_processed],#'template/mean_vs_est]"},{"type":"html","content":"<span class='clj-var'>#&#x27;template/variance_vs_est</span>","value":"#'template/variance_vs_est"}],"value":"[[[[[[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil],nil],#'template/abs_then_nroot],#'template/samples_rfib_processed],#'template/mean_vs_est],#'template/variance_vs_est]"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[[[[[[[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil],nil],#'template/abs_then_nroot],#'template/samples_rfib_processed],#'template/mean_vs_est],#'template/variance_vs_est],nil]"},{"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}],"value":"[[[[[[[[[[[[#'template/compute_mean,#'template/compute_var],#'template/mean_est],#'template/variance_est],nil],nil],nil],#'template/abs_then_nroot],#'template/samples_rfib_processed],#'template/mean_vs_est],#'template/variance_vs_est],nil],nil]"}
;; <=
