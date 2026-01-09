class Solution(object):
    def maxDotProduct(self, nums1, nums2):
        n, m = len(nums1), len(nums2)
        NEG = -10**9
        dp = [[NEG] * (m + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                prod = nums1[i - 1] * nums2[j - 1]
                dp[i][j] = max(
                    prod,
                    dp[i - 1][j],
                    dp[i][j - 1],
                    dp[i - 1][j - 1] + prod
                )
        return dp[n][m]