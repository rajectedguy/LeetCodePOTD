class Solution {
    fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
        fun longest(a: IntArray): Int {
            a.sort()
            var best = 1
            var cur = 1
            for (i in 1 until a.size) {
                if (a[i] == a[i - 1] + 1) cur++
                else cur = 1
                if (cur > best) best = cur
            }
            return best + 1
        }

        val side = minOf(longest(hBars), longest(vBars))
        return side * side
    }
}