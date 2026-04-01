class Solution {
    fun sumFourDivisors(nums: IntArray): Int {
        var ans = 0

        for (x in nums) {
            var n = x
            var p = 0
            var q = 0
            var cnt = 0

            var i = 2
            while (i * i <= n && cnt <= 2) {
                if (n % i == 0) {
                    cnt++
                    if (cnt == 1) p = i else q = i
                    while (n % i == 0) n /= i
                }
                i++
            }

            if (n > 1) {
                cnt++
                if (cnt == 1) p = n else q = n
            }

            if (cnt == 2 && p * q == x)
                ans += 1 + p + q + x
            else if (cnt == 1 && p * p * p == x)
                ans += 1 + p + p * p + x
        }

        return ans
    }
}