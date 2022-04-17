;; Throws an exception if n is greater than 20 because result can't fit in long
;; data type
(defn factorial [n]
  (if (= n 0) 1
      (* n (factorial (dec n)))))

;; Will work for n greater than 20 but may overflow stack because it uses
;; recursion
(defn factorial-bigint [n]
  (if (= n 0) 1
      (*' n (factorial (dec n)))))

;; Works perfectly fine avoiding overflows
(defn factorial-bigint-loop [n]
  (if (= n 0) 1
      (loop [val n i n]
        (if (<= i 1) val
            (recur (*' val (dec i)) (dec i))))))
