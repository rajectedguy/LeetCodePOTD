class Solution {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val m = nums2.size
        val NEG = -1_000_000_000
        val dp = Array(n + 1) { IntArray(m + 1) { NEG } }

        for (i in 1..n) {
            for (j in 1..m) {
                val prod = nums1[i - 1] * nums2[j - 1]
                dp[i][j] = maxOf(
                    prod,
                    dp[i - 1][j],
                    dp[i][j - 1],
                    dp[i - 1][j - 1] + prod
                )
            }
        }
        return dp[n][m]
    }
}