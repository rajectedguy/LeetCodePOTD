class Solution {
  int maxDotProduct(List<int> nums1, List<int> nums2) {
    int n = nums1.length, m = nums2.length;
    const int NEG = -1000000000;
    List<List<int>> dp =
        List.generate(n + 1, (_) => List.filled(m + 1, NEG));

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        int prod = nums1[i - 1] * nums2[j - 1];
        dp[i][j] = [
          prod,
          dp[i - 1][j],
          dp[i][j - 1],
          dp[i - 1][j - 1] + prod
        ].reduce((a, b) => a > b ? a : b);
      }
    }
    return dp[n][m];
  }
}