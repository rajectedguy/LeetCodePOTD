impl Solution {
    pub fn max_dot_product(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        let n = nums1.len();
        let m = nums2.len();
        let neg = -1_000_000_000;
        let mut dp = vec![vec![neg; m + 1]; n + 1];

        for i in 1..=n {
            for j in 1..=m {
                let prod = nums1[i - 1] * nums2[j - 1];
                dp[i][j] = std::cmp::max(
                    std::cmp::max(dp[i - 1][j], dp[i][j - 1]),
                    std::cmp::max(prod, dp[i - 1][j - 1] + prod),
                );
            }
        }
        dp[n][m]
    }
}