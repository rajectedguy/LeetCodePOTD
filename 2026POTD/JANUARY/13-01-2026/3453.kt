class Solution {
    fun separateSquares(squares: Array<IntArray>): Double {
        var lo = 1e18
        var hi = -1e18
        var total = 0.0
        for (s in squares) {
            val y = s[1].toDouble()
            val l = s[2].toDouble()
            if (y < lo) lo = y
            if (y + l > hi) hi = y + l
            total += l * l
        }
        val target = total / 2.0
        repeat(80) {
            val mid = (lo + hi) * 0.5
            var below = 0.0
            for (s in squares) {
                val y = s[1].toDouble()
                val l = s[2].toDouble()
                if (mid > y) {
                    var h = mid - y
                    if (h > l) h = l
                    below += h * l
                }
            }
            if (below < target) lo = mid else hi = mid
        }
        return lo
    }
}