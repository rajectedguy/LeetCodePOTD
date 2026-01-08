object Solution {
    def maxDotProduct(nums1: Array[Int], nums2: Array[Int]): Int = {
        val n = nums1.length
        val m = nums2.length
        val NEG = -1000000000
        val dp = Array.fill(n + 1, m + 1)(NEG)

        for (i <- 1 to n) {
            for (j <- 1 to m) {
                val prod = nums1(i - 1) * nums2(j - 1)
                dp(i)(j) = List(
                    prod,
                    dp(i - 1)(j),
                    dp(i)(j - 1),
                    dp(i - 1)(j - 1) + prod
                ).max
            }
        }
        dp(n)(m)
    }
}