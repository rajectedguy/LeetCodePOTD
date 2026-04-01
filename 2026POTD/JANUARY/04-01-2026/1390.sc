object Solution {
    def sumFourDivisors(nums: Array[Int]): Int = {
        var ans = 0

        for (x <- nums) {
            var n = x
            var p, q, cnt = 0

            var i = 2
            while (i * i <= n && cnt <= 2) {
                if (n % i == 0) {
                    cnt += 1
                    if (cnt == 1) p = i else q = i
                    while (n % i == 0) n /= i
                }
                i += 1
            }

            if (n > 1) {
                cnt += 1
                if (cnt == 1) p = n else q = n
            }

            if (cnt == 2 && p * q == x) ans += 1 + p + q + x
            else if (cnt == 1 && p * p * p == x) ans += 1 + p + p * p + x
        }

        ans
    }
}