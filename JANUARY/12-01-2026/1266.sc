object Solution {
    def minTimeToVisitAllPoints(points: Array[Array[Int]]): Int = {
        var ans = 0
        for (i <- 1 until points.length) {
            val dx = (points(i)(0) - points(i - 1)(0)).abs
            val dy = (points(i)(1) - points(i - 1)(1)).abs
            ans += math.max(dx, dy)
        }
        ans
    }
}