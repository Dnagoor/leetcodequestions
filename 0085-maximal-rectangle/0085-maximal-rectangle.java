class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Update histogram heights
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            // Solve histogram for current row
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {

                int height = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;

                max = Math.max(max, height * width);
            }

            if (i != n)
                st.push(i);
        }

        return max;
    }
}