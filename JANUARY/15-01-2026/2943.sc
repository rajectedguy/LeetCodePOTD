object Solution {
    def maximizeSquareHoleArea(n: Int, m: Int, hBars: Array[Int], vBars: Array[Int]): Int = {
        def longest(a: Array[Int]): Int = {
            scala.util.Sorting.quickSort(a)
            var best = 1
            var cur = 1
            for (i <- 1 until a.length) {
                if (a(i) == a(i - 1) + 1) cur += 1
                else cur = 1
                if (cur > best) best = cur
            }
            best + 1
        }

        val side = math.min(longest(hBars), longest(vBars))
        side * side
    }
}