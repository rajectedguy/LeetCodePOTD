object Solution {
  def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
    val a = arr.sorted
    val mn = (1 until a.length).map(i => a(i) - a(i - 1)).min
    (1 until a.length).filter(i => a(i) - a(i - 1) == mn)
      .map(i => List(a(i - 1), a(i))).toList
  }
}