class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var neg = 0
        var mn = Long.MAX_VALUE
        for (row in matrix) {
            for (x in row) {
                if (x < 0) neg++
                val ax = kotlin.math.abs(x.toLong())
                sum += ax
                if (ax < mn) mn = ax
            }
        }
        if (neg % 2 == 1) sum -= 2 * mn
        return sum
    }
}