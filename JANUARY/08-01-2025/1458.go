func maxDotProduct(nums1 []int, nums2 []int) int {
    n, m := len(nums1), len(nums2)
    const NEG = -1000000000
    dp := make([][]int, n+1)
    for i := range dp {
        dp[i] = make([]int, m+1)
        for j := range dp[i] {
            dp[i][j] = NEG
        }
    }

    for i := 1; i <= n; i++ {
        for j := 1; j <= m; j++ {
            prod := nums1[i-1] * nums2[j-1]
            a := dp[i-1][j]
            b := dp[i][j-1]
            c := dp[i-1][j-1] + prod
            d := prod
            dp[i][j] = a
            if b > dp[i][j] { dp[i][j] = b }
            if c > dp[i][j] { dp[i][j] = c }
            if d > dp[i][j] { dp[i][j] = d }
        }
    }
    return dp[n][m]
}