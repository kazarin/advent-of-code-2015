(ns advent-of-code.day2
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (io/resource "day2.txt"))

(def read-input
  (-> (slurp input)
      (str/trim)
      (str/split #"\n")))

(defn part1 []
  (reduce
    (fn [acc e]
      (let [[l h w] (map #(Integer/parseInt %) (str/split e #"x"))]
        (+
         acc
         (* 2 l w )
         (* 2 w h)
         (* 2 h l)
         (apply * (take 2 (sort [l h w]))))))
    0
    read-input))

(defn part2 []
  (reduce
    (fn [acc e]
      (let [[a b c] (sort (map #(Integer/parseInt %) (str/split e #"x")))]
        (+
         acc
         (+ (* 2 a) (* 2 b))
         (* a b c))))
    0
    read-input))
