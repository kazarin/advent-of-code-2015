(ns advent-of-code.day4
  (:import java.security.MessageDigest)
  (:require [clojure.string :as str]
            [clojure.core.async :as async]))

(def input "bgvyzdsv")

(defn md5 [s]
  (->> (-> (MessageDigest/getInstance "MD5")
           (.digest (.getBytes s "UTF-8")))
       (map #(format "%02x" %))
       (apply str)))

(defn find-hashes [zeroes]
  (loop [i 0]
    (if (str/starts-with? (md5 (str input i)) zeroes)
      i
      (recur (inc i)))))

(defn part1 []
  (find-hashes "00000"))

(defn part2 []
  (find-hashes "000000"))
