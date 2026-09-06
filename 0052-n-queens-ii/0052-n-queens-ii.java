class Solution {

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] leftRow = new int[n];
        int[] upperDia = new int[2 * n - 1];
        int[] lowerDia = new int[2 * n - 1];

        return solve(0, board, leftRow, upperDia, lowerDia, n);
    }

    public int solve(int row,
                     char[][] board,
                     int[] leftRow,
                     int[] upperDia,
                     int[] lowerDia,
                     int n) {

        // One complete solution found
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            int upper = (n - 1) + (col - row);
            int lower = col + row;

            if (leftRow[col] == 0
                    && upperDia[upper] == 0
                    && lowerDia[lower] == 0) {

                // Choose
                board[row][col] = 'Q';
                leftRow[col] = 1;
                upperDia[upper] = 1;
                lowerDia[lower] = 1;

                // Explore
                count += solve(row + 1, board,
                               leftRow, upperDia, lowerDia, n);

                // Undo
                board[row][col] = '.';
                leftRow[col] = 0;
                upperDia[upper] = 0;
                lowerDia[lower] = 0;
            }
        }

        return count;
    }
}