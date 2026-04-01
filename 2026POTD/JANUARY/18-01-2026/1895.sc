import scala.util.control.Breaks._

object Solution {
    def largestMagicSquare(grid: Array[Array[Int]]): Int = {
        val m = grid.length
        val n = grid(0).length

        val rowSum = Array.ofDim[Int](m, n + 1)
        val colSum = Array.ofDim[Int](m + 1, n)
        val diag1 = Array.ofDim[Int](m + 1, n + 1)
        val diag2 = Array.ofDim[Int](m + 1, n + 1)

        for (i <- 0 until m) {
            for (j <- 0 until n) {
                rowSum(i)(j + 1) = rowSum(i)(j) + grid(i)(j)
                colSum(i + 1)(j) = colSum(i)(j) + grid(i)(j)
                diag1(i + 1)(j + 1) = diag1(i)(j) + grid(i)(j)
                diag2(i + 1)(j) = diag2(i)(j + 1) + grid(i)(j)
            }
        }

        val maxK = Math.min(m, n)
        var result = 1

        breakable {
            for (k <- maxK to 1 by -1) {
                for (i <- 0 to m - k) {
                    for (j <- 0 to n - k) {
                        val d1 = diag1(i + k)(j + k) - diag1(i)(j)
                        val d2 = diag2(i + k)(j) - diag2(i)(j + k)
                        if (d1 == d2) {
                            var ok = true
                            for (x <- 0 until k if ok) {
                                val rsum = rowSum(i + x)(j + k) - rowSum(i + x)(j)
                                val csum = colSum(i + k)(j + x) - colSum(i)(j + x)
                                if (rsum != d1 || csum != d1) ok = false
                            }
                            if (ok) {
                                result = k
                                break
                            }
                        }
                    }
                }
            }
        }

        result
    }
}