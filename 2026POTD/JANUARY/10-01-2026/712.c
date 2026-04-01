int minimumDeleteSum(char* s1, char* s2) {
    int n = strlen(s1), m = strlen(s2);
    int dp[n + 1][m + 1];

    dp[n][m] = 0;

    for (int i = n - 1; i >= 0; i--)
        dp[i][m] = dp[i + 1][m] + s1[i];

    for (int j = m - 1; j >= 0; j--)
        dp[n][j] = dp[n][j + 1] + s2[j];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            if (s1[i] == s2[j])
                dp[i][j] = dp[i + 1][j + 1];
            else {
                int a = s1[i] + dp[i + 1][j];
                int b = s2[j] + dp[i][j + 1];
                dp[i][j] = a < b ? a : b;
            }
        }
    }

    return dp[0][0];
}