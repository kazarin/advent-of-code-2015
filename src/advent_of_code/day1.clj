(ns advent-of-code.day1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (io/resource "day1.txt"))

(def read-input
  (-> (slurp input)
      (str/trim)))

(defn part1 []
  (reduce
    #((if (= %2 \() + -) % 1)
    0
    (seq read-input)))
