impl Solution {
    pub fn minimum_delete_sum(s1: String, s2: String) -> i32 {
        let a = s1.as_bytes();
        let b = s2.as_bytes();
        let n = a.len();
        let m = b.len();
        let mut dp = vec![vec![0; m + 1]; n + 1];

        for i in (0..n).rev() {
            dp[i][m] = dp[i + 1][m] + a[i] as i32;
        }

        for j in (0..m).rev() {
            dp[n][j] = dp[n][j + 1] + b[j] as i32;
        }

        for i in (0..n).rev() {
            for j in (0..m).rev() {
                if a[i] == b[j] {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = std::cmp::min(
                        a[i] as i32 + dp[i + 1][j],
                        b[j] as i32 + dp[i][j + 1],
                    );
                }
            }
        }

        dp[0][0]
    }
}