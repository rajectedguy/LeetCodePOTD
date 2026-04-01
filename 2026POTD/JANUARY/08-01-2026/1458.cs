public class Solution {
    public int MaxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.Length, m = nums2.Length;
        int NEG = (int)-1e9;
        int[,] dp = new int[n + 1, m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i, j] = NEG;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int prod = nums1[i - 1] * nums2[j - 1];
                dp[i, j] = Math.Max(
                    Math.Max(dp[i - 1, j], dp[i, j - 1]),
                    Math.Max(prod, dp[i - 1, j - 1] + prod)
                );
            }
        }
        return dp[n, m];
    }
}