public class Solution {
    public int MaximalRectangle(char[][] matrix) {
        if (matrix.Length == 0) return 0;

        int rows = matrix.Length, cols = matrix[0].Length;
        int[] heights = new int[cols];
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }

            Stack<int> stack = new Stack<int>();
            for (int k = 0; k <= cols; k++) {
                int h = k == cols ? 0 : heights[k];
                while (stack.Count > 0 && h < heights[stack.Peek()]) {
                    int height = heights[stack.Pop()];
                    int width = stack.Count == 0 ? k : k - stack.Peek() - 1;
                    ans = Math.Max(ans, height * width);
                }
                stack.Push(k);
            }
        }

        return ans;
    }
}