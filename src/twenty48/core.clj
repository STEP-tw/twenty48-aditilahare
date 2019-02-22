(ns twenty48.core
  (:gen-class))

; >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

(def get-rid-of-zeros (partial remove zero?))

(def group-by-2-consecutive-equals
  (comp (partial mapcat (partial partition-all 2)) (comp (partial partition-by identity) (partial get-rid-of-zeros))))

(def add-consecutive-equals
  (comp (partial map (partial apply +)) group-by-2-consecutive-equals))

(defn add-subsequent-zeros [row]
  (take 4 (concat row (repeat 0))))

(def move-left (comp add-subsequent-zeros add-consecutive-equals))

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  (map move-left grid)
  )

; >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

(def move-right
  (comp reverse move-left reverse)
  )

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  (map move-right grid)
  )

; >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

; >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)


