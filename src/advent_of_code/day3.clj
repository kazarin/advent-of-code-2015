(ns advent-of-code.day3
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (io/resource "day3.txt"))

(def read-input
  (-> (slurp input)
      (str/trim)
      (seq)))

(defn get-direction [sym]
  (case sym
    \> [[:x] inc]
    \< [[:x] dec]
    \^ [[:y] inc]
    \v [[:y] dec]))

(defn go [directions]
  (loop [input  directions
         coords {:x 0 :y 0}
         result []]
    (if (empty? input)
      result
      (let [direction (get-direction (first input))]
        (recur (next input)
               (apply update-in coords direction)
               (conj result (vals coords)))))))

(defn part1 []
  (count (distinct (go read-input))))

(defn part2 []
  (count (distinct (into (go (take-nth 2 read-input))
        (go (take-nth 2 (next read-input)))))))
