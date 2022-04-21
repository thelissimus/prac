;; Tried to solve FizzBuzz in a functional way
(defn fizz-buzz [n]
  (cond (zero? (mod n 15)) "FizzBuzz"
        (zero? (mod n 3)) "Fizz"
        (zero? (mod n 5)) "Buzz"
        :else n))

;; There is another way (from docs) which I like more.
(defn fizz-buzz [n]
  (cond-> nil
    (zero? (mod n 3)) (str "Fizz")
    (zero? (mod n 5)) (str "Buzz")
    :always           (or n)))
