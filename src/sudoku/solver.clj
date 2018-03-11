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
(defn get-options-set
  "Takes an initial unsolved sudoku and returns a map with keys for each location
  with possible options to use"
  [sudoku]
  (map-indexed
    (fn [idx itm]
      (if (not (nil? itm))
        itm
        (let [threes (partition 3 (range 81))
              mini-grids [(mapcat #(nth threes %) [0 3 6])
                          (mapcat #(nth threes %) [1 4 7])
                          (mapcat #(nth threes %) [2 5 8])
                          (mapcat #(nth threes %) [9 12 15])
                          (mapcat #(nth threes %) [10 13 16])
                          (mapcat #(nth threes %) [11 14 17])
                          (mapcat #(nth threes %) [18 21 24])
                          (mapcat #(nth threes %) [19 22 25])
                          (mapcat #(nth threes %) [20 23 26])]]
          (remove
            (into #{}
              (remove nil?
                (concat
                  (map #(nth sudoku %) (map #(+ (mod idx 9) (* 9 %)) (range 9)))
                  (map #(nth sudoku %) (map #(+ % (* 9 (int (/ idx 9)))) (range 9)))
                  (map #(nth sudoku %) (first (filter #(contains? (set %) idx) mini-grids))))))
            (set (range 1 10))))))
    sudoku))
      ;[(int (/ idx 9)) (mod idx 9)]
      ;(map #(nth sudoku %) (map #(+ (mod idx 9) (* 9 %)) (range 9)));col values
      ;(map #(nth sudoku %) (map #(+ % (* 9 (int (/ idx 9)))) (range 9)));row values

(get-options-set sudoku)

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
