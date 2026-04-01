import scala.util.control.Breaks._

object Solution {
    def maxSideLength(mat: Array[Array[Int]], threshold: Int): Int = {
        val m = mat.length
        val n = mat(0).length


        val prefix = Array.ofDim[Int](m + 1, n + 1)
        for (i <- 0 until m; j <- 0 until n) {
            prefix(i + 1)(j + 1) = mat(i)(j) + prefix(i)(j + 1) + prefix(i + 1)(j) - prefix(i)(j)
        }

        var left = 0
        var right = math.min(m, n)
        var ans = 0

        while (left <= right) {
            val mid = (left + right) / 2
            var found = false

            breakable {
                for (i <- mid to m) {
                    for (j <- mid to n) {
                        val total = prefix(i)(j) - prefix(i - mid)(j) - prefix(i)(j - mid) + prefix(i - mid)(j - mid)
                        if (total <= threshold) {
                            found = true
                            break
                        }
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

        ans
    }
}