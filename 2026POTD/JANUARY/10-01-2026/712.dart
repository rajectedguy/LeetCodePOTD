class Solution {
  int minimumDeleteSum(String s1, String s2) {
    int n = s1.length, m = s2.length;
    List<List<int>> dp =
        List.generate(n + 1, (_) => List.filled(m + 1, 0));

    for (int i = n - 1; i >= 0; i--) {
      dp[i][m] = dp[i + 1][m] + s1.codeUnitAt(i);
    }

    for (int j = m - 1; j >= 0; j--) {
      dp[n][j] = dp[n][j + 1] + s2.codeUnitAt(j);
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (s1[i] == s2[j]) {
          dp[i][j] = dp[i + 1][j + 1];
        } else {
          dp[i][j] = [
            s1.codeUnitAt(i) + dp[i + 1][j],
            s2.codeUnitAt(j) + dp[i][j + 1]
          ].reduce((a, b) => a < b ? a : b);
        }
      }
    }

    return dp[0][0];
  }
}