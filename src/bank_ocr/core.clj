(ns bank-ocr.core
  (:require [clojure.string :as str]))

(def digits
 {" _ | ||_|" "0"
  "     |  |" "1"
  " _  _||_ " "2"
  " _  _| _|" "3"
  "   |_|  |" "4"
  " _ |_  _|" "5"
  " _ |_ |_|" "6"
  " _   |  |" "7"
  " _ |_||_|" "8"
  " _ |_| _|" "9"})

(defn strip-whitespace
  "Returns a represented digit with whitespace stripped"
  [digit]
  (str/replace digit #"\n" ""))

(defn parse-digit
  "Parses a single digit from file and returns the appropriate single-character
   digit representation"
  [digit]
  (get digits (strip-whitespace digit)))

(defn account-number->digits
  "Takes an account number string and groups it into a seq of individual 
   digit representations"
  [account-number]
  (let [chunks (partition 3 account-number)
        indexed-chunks (map-indexed vector chunks)
        grouped-chunks (group-by #(mod (first %) 9) indexed-chunks)]
    (->> (map #(map second %) (vals grouped-chunks))
         (flatten)
         (partition 9)
         (map #(apply str %)))))

(defn process-entry
  "Parses an account into a human-readable format"
  [entry]
  (account-number->digits entry))

(defn read-account-entry
  [entry-lines]
  (->> (process-entry (butlast entry-lines))
       (map parse-digit)
       (apply str)))

