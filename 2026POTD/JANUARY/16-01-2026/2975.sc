object Solution {
    def maximizeSquareArea(m: Int, n: Int, hFences: Array[Int], vFences: Array[Int]): Int = {
        val MOD: Long = 1000000007L

        val h = (hFences ++ Array(1, m)).sorted
        val v = (vFences ++ Array(1, n)).sorted

        val hs = scala.collection.mutable.Set[Int]()
        for (i <- h.indices; j <- i + 1 until h.length) {
            hs.add(h(j) - h(i))
        }

        var best = -1
        for (i <- v.indices; j <- i + 1 until v.length) {
            val d = v(j) - v(i)
            if (hs.contains(d)) best = Math.max(best, d)
        }

        if (best == -1) -1 else ((best.toLong * best.toLong) % MOD).toInt
    }
}