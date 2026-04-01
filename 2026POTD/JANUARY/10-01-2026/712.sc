object Solution {
    def minimumDeleteSum(s1: String, s2: String): Int = {
        val n = s1.length
        val m = s2.length
        val dp = Array.ofDim[Int](n + 1, m + 1)

        for (i <- n - 1 to 0 by -1)
            dp(i)(m) = dp(i + 1)(m) + s1.charAt(i).toInt

        for (j <- m - 1 to 0 by -1)
            dp(n)(j) = dp(n)(j + 1) + s2.charAt(j).toInt

        for (i <- n - 1 to 0 by -1) {
            for (j <- m - 1 to 0 by -1) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp(i)(j) = dp(i + 1)(j + 1)
                else
                    dp(i)(j) = math.min(
                        s1.charAt(i).toInt + dp(i + 1)(j),
                        s2.charAt(j).toInt + dp(i)(j + 1)
                    )
            }
        }

        dp(0)(0)
    }
}