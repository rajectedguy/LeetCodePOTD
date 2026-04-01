class Solution {
  int maximalRectangle(List<List<String>> matrix) {
    if (matrix.isEmpty) return 0;

    int cols = matrix[0].length;
    List<int> heights = List.filled(cols, 0);
    int ans = 0;

    for (var row in matrix) {
      for (int j = 0; j < cols; j++) {
        heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
      }

      List<int> stack = [];
      for (int i = 0; i <= cols; i++) {
        int h = i == cols ? 0 : heights[i];
        while (stack.isNotEmpty && h < heights[stack.last]) {
          int height = heights[stack.removeLast()];
          int width = stack.isEmpty ? i : i - stack.last - 1;
          ans = ans > height * width ? ans : height * width;
        }
        stack.add(i);
      }
    }

    return ans;
  }
}