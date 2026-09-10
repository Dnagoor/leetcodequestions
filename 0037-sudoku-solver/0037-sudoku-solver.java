class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] sudoku) {

        for (int i = 0; i < sudoku.length; i++) {

            for (int j = 0; j < sudoku[0].length; j++) {

                if (sudoku[i][j] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isValid(i, j, ch, sudoku)) {

                            // Choose
                            sudoku[i][j] = ch;

                            // Explore
                            if (solve(sudoku)) {
                                return true;
                            }

                            // Undo
                            sudoku[i][j] = '.';
                        }
                    }

                    // No number worked
                    return false;
                }
            }
        }

        // No empty cells left
        return true;
    }

    public boolean isValid(int row, int col,
                           char ch, char[][] sudoku) {

        for (int i = 0; i < 9; i++) {

            // Row
            if (sudoku[row][i] == ch) {
                return false;
            }

            // Column
            if (sudoku[i][col] == ch) {
                return false;
            }

            // 3 x 3 box
            if (sudoku[3 * (row / 3) + i / 3]
                    [3 * (col / 3) + i % 3] == ch) {
                return false;
            }
        }

        return true;
    }
}