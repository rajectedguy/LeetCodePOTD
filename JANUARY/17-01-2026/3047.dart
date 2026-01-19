class Solution {
  int largestSquareArea(List<List<int>> bottomLeft, List<List<int>> topRight) {
    int n = bottomLeft.length;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int x1 = bottomLeft[i][0] > bottomLeft[j][0]
            ? bottomLeft[i][0]
            : bottomLeft[j][0];
        int y1 = bottomLeft[i][1] > bottomLeft[j][1]
            ? bottomLeft[i][1]
            : bottomLeft[j][1];
        int x2 = topRight[i][0] < topRight[j][0]
            ? topRight[i][0]
            : topRight[j][0];
        int y2 = topRight[i][1] < topRight[j][1]
            ? topRight[i][1]
            : topRight[j][1];
        if (x2 > x1 && y2 > y1) {
          int side = (x2 - x1) < (y2 - y1) ? (x2 - x1) : (y2 - y1);
          int area = side * side;
          if (area > ans) ans = area;
        }
      }
    }
    return ans;
  }
}