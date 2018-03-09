(ns sudoku.solver-test
  (:require [clojure.test :refer :all]
            [sudoku.solver :as test-subject]))


(deftest sudoku-test

  (testing "Sudoku puzzle can be completed"

    (let [_ nil
          start-position [_ _ 6 _ 5 4 9 _ _
                          1 _ _ _ 6 _ _ 4 2
                          7 _ _ _ 8 9 _ _ _
                          _ 7 _ _ _ 5 _ 8 1
                          _ 5 _ 3 4 _ 6 _ _
                          4 _ 2 _ _ _ _ _ _
                          _ 3 4 _ _ _ 1 _ _
                          9 _ _ 8 _ _ _ 5 _
                          _ _ _ 4 _ _ 3 _ 7]
          end-position [2 8 6 1 5 4 9 7 3
                        1 9 5 7 6 3 8 4 2
                        7 4 3 2 8 9 5 1 6
                        3 7 9 6 2 5 4 8 1
                        8 5 1 3 4 7 6 2 9
                        4 6 2 9 1 8 7 3 5
                        6 3 4 5 7 2 1 9 8
                        9 1 7 8 3 6 2 5 4
                        5 2 8 4 9 1 3 6 7]]

      (is (= (test-subject/solve start-position) end-position)))))
