;; Tried to solve FizzBuzz in a functional way
(defn fizz-buzz [n]
  (cond (zero? (mod n 15)) "FizzBuzz"
        (zero? (mod n 3)) "Fizz"
        (zero? (mod n 5)) "Buzz"
        :else n))

(println
 (map fizz-buzz (range 1 101)))
