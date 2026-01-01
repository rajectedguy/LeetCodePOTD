object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    val n = digits.length
    var i = n - 1
    while (i >= 0) {
      if (digits(i) < 9) {
        digits(i) += 1
        return digits
      } else {
        digits(i) = 0
      }
      i -= 1
    }
    Array(1) ++ digits
  }
}