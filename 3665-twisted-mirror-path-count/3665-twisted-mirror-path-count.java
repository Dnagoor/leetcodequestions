class Solution {
    public int uniquePaths(int[][] grid) {
        final int mod = 1_000_000_007;
        int[] down = new int[grid[0].length];  // ways to enter each cell from above
        down[0] = 1;
        for (int[] row : grid) {
            int right = 0;  // ways to enter the current cell from the left
            for (int j = 0; j < row.length; j++) {
                int above = down[j], merged = right + above;  // an empty cell merges them
                merged -= merged >= mod ? mod : 0;  // both are below mod: one subtraction replaces %
                int mask = -row[j];  // all ones for a mirror, 0 for an empty cell
                down[j] = merged ^ ((merged ^ right) & mask);  // a mirror swaps the flows: mask ? right : merged
                right = merged ^ ((merged ^ above) & mask);  // mask ? above : merged
            }
        }
        return down[down.length - 1];
    }
}