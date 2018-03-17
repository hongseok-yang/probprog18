(ns bounce
  (:require [org.nfrac.cljbox2d.testbed :as bed]
            [org.nfrac.cljbox2d.core :refer :all]
            [org.nfrac.cljbox2d.vec2d :as vec2d]
            [quil.core :as quil]
            [quil.middleware])
  (:use [clojure.data.priority-map]))


(def circ-attr {:density 1.0
                :category-bits 0x0008
                :mask-bits 0xFFFF})

(defn sanitize
  "ensure that input pairs have type vec2"
  [bumper-positions]
  (mapv (fn [pos]
          (if (= (type pos) org.jbox2d.common.Vec2)
            pos (vec2 pos)))
        bumper-positions))

(defn create-world
  "creates a world given bumper positions and ball bodies,
  which are used to copy bodies for post-inference display"
  ([bumper-positions] (create-world bumper-positions nil))
  ([bumper-positions balls]
   (let [bumper-positions (sanitize bumper-positions)
         world (new-world)

                                        ; creates target cup
         cup_center 15
         cup_floor (body! world {:type :static}
                          {:shape (edge [(- cup_center 1) 0] [(+ cup_center 1) 0])
                           :friction 0.3 :restitution 0.0})
         cup_left_wall (body! world {:type :static}
                              {:shape (edge [(- cup_center 1) 0] [(- cup_center 1) 2])
                               :friction 0.3 :restitution 0.0})
         cup_right_wall (body! world {:type :static}
                               {:shape (edge [(+ cup_center 1) 0] [(+ cup_center 1) 2])
                                :friction 0.3 :restitution 0.0})

                                        ; creates ramp
         ramp (body! world {:type :static}
                     {:shape (edge [-6 9] [-4 7])
                      :friction 0.2 :restitution 0.0})

                                        ; if a list of balls are passed in re-create
                                        ; new balls at the old balls' positions
         _ (if (not (nil? balls))
             (loop [bs balls]
               (if (empty? bs)
                 nil
                 (let [b (first bs)]
                   (body! world {:position (position b)}
                                        ; TODO generalize to copy body (or attrs),
                                        ; not just create a new ball at the same
                                        ; location
                          (assoc circ-attr
                                 :shape (circle 0.25) :restitution 0.5
                                 :group-index 1))
                   (recur (rest bs))))))



                                        ; creates bumpers
         _ (loop [x bumper-positions]
             (if (empty? x)
               nil
               (let
                   [[xx yy] (v2xy (first x))
                                        ;_ (prn [xx yy])
                    lpos [(- xx 0.5) yy]
                                        ;_ (prn lpos)
                    rpos [(+ xx 0.5) yy]
                                        ;_ (prn rpos)
                    ]
                 (body! world {:type :static}
                        {:shape (edge lpos rpos)
                         :friction 0.3 :restitution 0.9})
                 (recur (rest x)))))]
     world)))


(defn setup [bumper-positions balls]
  "creates world and sets up state for running quil simulation"
  (quil/frame-rate 30)
  (let [world (create-world bumper-positions balls)]
    (assoc bed/initial-state
      :last 0.0
      :numballs 0
      :world world)))

(defn step
  "steps the simulation one timestep forward (in quil simluation)
   creating 20 balls/bodies as the simulation runs forward"
  [state]
  (let [now (:time state)
        contacts (all-current-contacts (:world state))]
    (do
      (if (and (> now (+ (:last state)
                         (/ 20.0 30.0)))
               (< (:numballs state) 20))
        (do
          (body! (:world state)
                 ;;{:position [-5 (+ 8.25 0.1)]};(sample (gamma 0.2 0.2)))]}
                 {:position [-5 (+ 8.25 0.1 (* 0.1 (rand)))]}
                 (assoc circ-attr
                   :shape (circle 0.25)
                   :restitution 0.5
                   :group-index 1))
          (-> (update-in state [:last] (fn [a b] b) now)
              (update-in [:numballs] + 1)
              (bed/world-step)
              (bed/record-snapshot true)))
        (-> (bed/world-step state)
            (bed/record-snapshot true))))))

(defn draw
  "quil state drawing function"
  [state]
  (bed/draw state)
  (quil/fill 255)
  (quil/text (str "Bounce.\n")
             10 10))

(defn simulate-world
  "simulates the world for 20 sec. outside of quil
  creating 20 balls, one every 2/3's of a sec."
  [world]
  (let [dt (/ 1.0 30.0)
        duration 20.0
        dts-between-balls 20
        bodies (loop [t 0.0 c 0 bodies []]
                       (if (> t duration)
                         bodies
                         (do
                           (step! world dt)
                           (if (and (= c dts-between-balls)
                                    (< (count bodies) 20))
                             (let [new-ball
                                   (body! world
                                     {:position
                                      ;[-5 (+ 8.25 0.1)]};(sample (gamma 0.2 0.2)))]}
                                      [-5 (+ 8.25 0.1 (* 0.1 (rand)))]}
                                     (assoc circ-attr
                                       :shape (circle 0.25)
                                       :restitution 0.5
                                       :group-index 1))]
                               (recur (+ t dt)
                                      0
                                      (conj bodies new-ball)))
                             (recur (+ t dt)
                                    (+ c 1)
                                    bodies)))))]
    {:balls bodies}))


(defn display-static-world [bumper-positions balls]
  "displays a static world with bumpers and balls"
 (quil/sketch
   :title "Bounce"
   :setup (partial setup bumper-positions balls)
   :update identity
   :draw draw
   :key-typed bed/key-press
   :mouse-pressed bed/mouse-pressed
   :mouse-released bed/mouse-released
   :mouse-dragged bed/mouse-dragged
   :mouse-wheel bed/mouse-wheel
   :size [600 500]
   :features [:resizable :keep-on-top]
   :middleware [quil.middleware/fun-mode]))

(defn show-world-simulation [bumper-positions]
  "simulates and displays a world with bumpers
  creating 20 balls during the simulation"
   (quil/sketch
   :title "Bounce"
   :setup (partial setup bumper-positions nil)
   :update (fn [s] (if (:paused? s) s (step s)))
   :draw draw
   :key-typed bed/key-press
   :mouse-pressed bed/mouse-pressed
   :mouse-released bed/mouse-released
   :mouse-dragged bed/mouse-dragged
   :mouse-wheel bed/mouse-wheel
   :size [600 500]
   :features [:resizable :keep-on-top]
   :middleware [quil.middleware/fun-mode]))

(defn linspace
  "creates a list of n values
  linearly distributed between min
  and max inclusive"
  [min max n]
   (let [step (/ (- max min) (dec n))]
      (range min (+ max step) step)))

;; we need an observable signal and the number
;; of balls in the box after 20 sec. of simulation
;; is something we can count; here's a function
;; to do that
(defn balls-in-box [world]
  "computes number of balls that
  are in the box in the given
  world";
  ;(-ish, problem specific hack)
  (->> (:balls world)
     (map position)
     (filter #(and (< 0 (second %)) (< (second %) 3) (< 14 (first %))))
     (count)))
