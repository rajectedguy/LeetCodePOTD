class Solution {
    fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        val n = bottomLeft.size
        var ans = 0L
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val x1 = maxOf(bottomLeft[i][0], bottomLeft[j][0])
                val y1 = maxOf(bottomLeft[i][1], bottomLeft[j][1])
                val x2 = minOf(topRight[i][0], topRight[j][0])
                val y2 = minOf(topRight[i][1], topRight[j][1])
                if (x2 > x1 && y2 > y1) {
                    val side = minOf(x2 - x1, y2 - y1)
                    val area = side.toLong() * side.toLong()
                    if (area > ans) ans = area
                }
            }
        }
        return ans
    }
}