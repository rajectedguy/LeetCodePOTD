object Solution {
    def maxMatrixSum(matrix: Array[Array[Int]]): Long = {
        var sum = 0L
        var neg = 0
        var mn = Long.MaxValue
        for (row <- matrix; x <- row) {
            if (x < 0) neg += 1
            val ax = math.abs(x.toLong)
            sum += ax
            if (ax < mn) mn = ax
        }
        if (neg % 2 == 1) sum -= 2 * mn
        sum
    }
}