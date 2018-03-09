(ns sudoku.solver)

(def sudoku
  (let [_ nil]
     [_ _ 6 _ 5 4 9 _ _
      1 _ _ _ 6 _ _ 4 2
      7 _ _ _ 8 9 _ _ _
      _ 7 _ _ _ 5 _ 8 1
      _ 5 _ 3 4 _ 6 _ _
      4 _ 2 _ _ _ _ _ _
      _ 3 4 _ _ _ 1 _ _
      9 _ _ 8 _ _ _ 5 _
      _ _ _ 4 _ _ 3 _ 7]))
(map-indexed vector sudoku)
(map-indexed
  (fn [idx itm]
    (if (not (nil? itm))
      itm
      ;[(int (/ idx 9)) (mod idx 9)]
      ;(map #(nth sudoku %) (map #(+ (mod idx 9) (* 9 %)) (range 9)));col values
      ;(map #(nth sudoku %) (map #(+ % (* 9 (int (/ idx 9)))) (range 9)));row values
      (remove
      (into #{}
        (remove nil?
          (concat
            (map #(nth sudoku %) (map #(+ (mod idx 9) (* 9 %)) (range 9)))
            (map #(nth sudoku %) (map #(+ % (* 9 (int (/ idx 9)))) (range 9))))))
        (set (range 1 10)))
      ))
  sudoku)
(get-options-set (partition 9 sudoku) sudoku)
(defn get-options-set
  "Takes an initial unsolved sudoku and returns a map with keys for each location
  with possible options to use"
  [grid sudoku]
  (let [all-options-set (set (range 1 10))
        col-values (apply map vector grid)]
    (for [y (range 9)]
      (let [row-values (nth grid y)]
        (for [x (range 9)]
          (if (not (nil? (nth sudoku (+ x (* y 9)))))
            (nth sudoku (+ x (* y 9)))
            (remove
              (into #{} (remove nil? (concat (nth col-values x) row-values)))
              all-options-set)))))))


            ;:let [value (nth (nth grid x) y)))

    (if (not nil? value)
      value
      (let ))))

(defn solve
  "Takes a sequence of numbers representing a possibly incomplete Sudoku puzzle
   and returns a sequence of numbers representing a completed solution to the puzzle.

   A completed sudoku puzzle has the following properties:
     Every row contains the digits 1-9 exactly once.
     Every column contains the digits 1-9 exactly once.
     Breaking the grid into 9 non-overlapping 3 by 3 sub-grids,
       every sub-grid contains the digits 1-9 exactly once.

   See the test for an example."

  [sudoku]

  ; TODO: Implement this...
  (let [grid (partition 9 sudoku)
        options-set (get-options-set grid)]
    (for ))
  )
