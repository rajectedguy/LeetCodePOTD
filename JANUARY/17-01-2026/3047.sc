object Solution {
    def largestSquareArea(bottomLeft: Array[Array[Int]], topRight: Array[Array[Int]]): Long = {
        val n = bottomLeft.length
        var ans = 0L
        for (i <- 0 until n; j <- i + 1 until n) {
            val x1 = math.max(bottomLeft(i)(0), bottomLeft(j)(0))
            val y1 = math.max(bottomLeft(i)(1), bottomLeft(j)(1))
            val x2 = math.min(topRight(i)(0), topRight(j)(0))
            val y2 = math.min(topRight(i)(1), topRight(j)(1))
            if (x2 > x1 && y2 > y1) {
                val side = math.min(x2 - x1, y2 - y1).toLong
                val area = side * side
                if (area > ans) ans = area
            }
        }
        ans
    }
}