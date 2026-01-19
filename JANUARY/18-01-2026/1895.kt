class Solution {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val rowSum = Array(m) { IntArray(n + 1) }
        val colSum = Array(m + 1) { IntArray(n) }
        val diag1 = Array(m + 1) { IntArray(n + 1) } 
        val diag2 = Array(m + 1) { IntArray(n + 1) } 

        for (i in 0 until m) {
            for (j in 0 until n) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j]
                colSum[i + 1][j] = colSum[i][j] + grid[i][j]
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j]
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j]
            }
        }

        val maxK = minOf(m, n)
        for (k in maxK downTo 1) {
            for (i in 0..m - k) {
                for (j in 0..n - k) {
                    val d1 = diag1[i + k][j + k] - diag1[i][j]
                    val d2 = diag2[i + k][j] - diag2[i][j + k]
                    if (d1 != d2) continue

                    var ok = true
                    for (x in 0 until k) {
                        val rsum = rowSum[i + x][j + k] - rowSum[i + x][j]
                        val csum = colSum[i + k][j + x] - colSum[i][j + x]
                        if (rsum != d1 || csum != d1) {
                            ok = false
                            break
                        }
                    }
                    if (ok) return k
                }
            }
        }

        return 1
    }
}