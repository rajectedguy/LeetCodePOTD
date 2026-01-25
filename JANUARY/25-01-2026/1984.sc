object Solution {
    def minimumDifference(nums: Array[Int], k: Int): Int = {
        if (k <= 1) return 0
        val a = nums.sorted
        var ans = Int.MaxValue
        for (i <- 0 to a.length - k) {
            ans = math.min(ans, a(i + k - 1) - a(i))
        }
        ans
    }
}