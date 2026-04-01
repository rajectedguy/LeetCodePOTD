class Solution {
  int maxSideLength(List<List<int>> mat, int threshold) {
    int m = mat.length;
    int n = mat[0].length;

    List<List<int>> prefix = List.generate(m + 1, (_) => List.filled(n + 1, 0));
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        prefix[i + 1][j + 1] =
            mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j];
      }
    }

    int left = 0, right = m < n ? m : n, ans = 0;

    while (left <= right) {
      int mid = (left + right) ~/ 2;
      bool found = false;

      outer:
      for (int i = mid; i <= m; i++) {
        for (int j = mid; j <= n; j++) {
          int total = prefix[i][j] -
              prefix[i - mid][j] -
              prefix[i][j - mid] +
              prefix[i - mid][j - mid];
          if (total <= threshold) {
            found = true;
            break outer;
          }
        }
      }

      if (found) {
        ans = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return ans;
  }
}