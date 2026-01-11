class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0

        val cols = matrix[0].size
        val heights = IntArray(cols)
        var ans = 0

        for (row in matrix) {
            for (j in 0 until cols) {
                heights[j] = if (row[j] == '1') heights[j] + 1 else 0
            }

            val stack = java.util.Stack<Int>()
            for (i in 0..cols) {
                val h = if (i == cols) 0 else heights[i]
                while (stack.isNotEmpty() && h < heights[stack.peek()]) {
                    val height = heights[stack.pop()]
                    val width = if (stack.isEmpty()) i else i - stack.peek() - 1
                    ans = maxOf(ans, height * width)
                }
                stack.push(i)
            }
        }

        return ans
    }
}