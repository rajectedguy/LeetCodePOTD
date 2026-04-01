class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length
        val dp = Array(n + 1) { IntArray(m + 1) }

        for (i in n - 1 downTo 0)
            dp[i][m] = dp[i + 1][m] + s1[i].code

        for (j in m - 1 downTo 0)
            dp[n][j] = dp[n][j + 1] + s2[j].code

        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                dp[i][j] = if (s1[i] == s2[j]) {
                    dp[i + 1][j + 1]
                } else {
                    minOf(
                        s1[i].code + dp[i + 1][j],
                        s2[j].code + dp[i][j + 1]
                    )
                }
            }
        }

        return dp[0][0]
    }
}