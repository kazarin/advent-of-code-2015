(ns advent-of-code.day1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (io/resource "day1.txt"))

(def read-input
  (-> (slurp input)
      (str/trim)))

(defn part1 []
  (reduce
    #((if (= %2 \() inc dec) %1)
    0
    (seq read-input)))

(defn part2 []
  (loop [index      0
         brackets   (seq read-input)
         result     0]
    (if (= result -1)
      index
      (recur
        (inc index)
        (next brackets)
        (#((if (= (first brackets) \() inc dec) result))))))
