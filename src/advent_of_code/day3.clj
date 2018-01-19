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

(defn part1 []
  (loop [input  read-input
         coords {:x 0 :y 0}
         result []]
    (if (empty? input)
      (count (distinct result))
      (let [direction (get-direction (first input))]
        (recur (next input)
               (apply update-in coords direction)
               (conj result (vals coords)))))))
