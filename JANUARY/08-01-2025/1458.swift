class Solution {
    func maxDotProduct(_ nums1: [Int], _ nums2: [Int]) -> Int {
        let n = nums1.count
        let m = nums2.count
        let NEG = -1_000_000_000
        var dp = Array(repeating: Array(repeating: NEG, count: m + 1), count: n + 1)

        for i in 1...n {
            for j in 1...m {
                let prod = nums1[i - 1] * nums2[j - 1]
                dp[i][j] = max(
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