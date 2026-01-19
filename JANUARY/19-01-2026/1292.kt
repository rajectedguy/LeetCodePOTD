class Solution {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val m = mat.size
        val n = mat[0].size
        val prefix = Array(m + 1) { IntArray(n + 1) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j]
            }
        }

        var left = 0
        var right = minOf(m, n)
        var ans = 0

        while (left <= right) {
            val mid = (left + right) / 2
            var found = false

            loop@ for (i in mid..m) {
                for (j in mid..n) {
                    val total = prefix[i][j] - prefix[i - mid][j] - prefix[i][j - mid] + prefix[i - mid][j - mid]
                    if (total <= threshold) {
                        found = true
                        break@loop
                    }
                }
            }

            if (found) {
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return ans
    }
}