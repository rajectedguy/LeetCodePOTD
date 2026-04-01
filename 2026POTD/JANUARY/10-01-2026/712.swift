class Solution {
    func minimumDeleteSum(_ s1: String, _ s2: String) -> Int {
        let a = Array(s1), b = Array(s2)
        let n = a.count, m = b.count
        var dp = Array(repeating: Array(repeating: 0, count: m + 1), count: n + 1)

        for i in stride(from: n - 1, through: 0, by: -1) {
            dp[i][m] = dp[i + 1][m] + Int(a[i].asciiValue!)
        }

        for j in stride(from: m - 1, through: 0, by: -1) {
            dp[n][j] = dp[n][j + 1] + Int(b[j].asciiValue!)
        }

        for i in stride(from: n - 1, through: 0, by: -1) {
            for j in stride(from: m - 1, through: 0, by: -1) {
                if a[i] == b[j] {
                    dp[i][j] = dp[i + 1][j + 1]
                } else {
                    dp[i][j] = min(
                        Int(a[i].asciiValue!) + dp[i + 1][j],
                        Int(b[j].asciiValue!) + dp[i][j + 1]
                    )
                }
            }
        }

        return dp[0][0]
    }
}