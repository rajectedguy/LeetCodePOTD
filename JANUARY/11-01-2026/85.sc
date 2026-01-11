object Solution {
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) return 0

    val cols = matrix(0).length
    val heights = Array.fill(cols)(0)
    var ans = 0

    for (row <- matrix) {
      for (j <- 0 until cols) {
        heights(j) = if (row(j) == '1') heights(j) + 1 else 0
      }

      val stack = scala.collection.mutable.Stack[Int]()
      for (i <- 0 to cols) {
        val h = if (i == cols) 0 else heights(i)
        while (stack.nonEmpty && h < heights(stack.top)) {
          val height = heights(stack.pop())
          val width = if (stack.isEmpty) i else i - stack.top - 1
          ans = math.max(ans, height * width)
        }
        stack.push(i)
      }
    }

    ans
  }
}