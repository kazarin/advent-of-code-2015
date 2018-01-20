(ns advent-of-code.day5
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (io/resource "day5.txt"))

(def read-input
  (-> (slurp input)
      (str/trim)
      (str/split #"\n")))


(defn valid? [s]
  (and (not (re-find #"ab|cd|pq|xy" s))
       (re-find #"([a-z])\1{1}" s)
       (> (count (filter
                   #(re-find #"a|e|i|o|u"  %) (str/split s #"")))
          2)))

(defn part1 []
  (loop [strings read-input
         result  0]
    (if (empty? strings)
      result
      (recur (next strings) (if (valid? (first strings))
                              (inc result)
                              result)))))
