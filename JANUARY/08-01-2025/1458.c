int maxDotProduct(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int n = nums1Size, m = nums2Size;
    int NEG = -1000000000;
    int dp[n + 1][m + 1];
    
    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= m; j++)
            dp[i][j] = NEG;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            int prod = nums1[i - 1] * nums2[j - 1];
            int a = dp[i - 1][j];
            int b = dp[i][j - 1];
            int c = dp[i - 1][j - 1] + prod;
            int d = prod;
            int max = a > b ? a : b;
            max = max > c ? max : c;
            max = max > d ? max : d;
            dp[i][j] = max;
        }
    }
    return dp[n][m];
}