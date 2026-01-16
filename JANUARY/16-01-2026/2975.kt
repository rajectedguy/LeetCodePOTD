class Solution {
    fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        val MOD = 1_000_000_007L

        val h = IntArray(hFences.size + 2)
        val v = IntArray(vFences.size + 2)

        h[0] = 1
        h[1] = m
        v[0] = 1
        v[1] = n

        for (i in hFences.indices) h[i + 2] = hFences[i]
        for (i in vFences.indices) v[i + 2] = vFences[i]

        h.sort()
        v.sort()

        val hs = HashSet<Int>()
        for (i in h.indices)
            for (j in i + 1 until h.size)
                hs.add(h[j] - h[i])

        var best = -1
        for (i in v.indices) {
            for (j in i + 1 until v.size) {
                val d = v[j] - v[i]
                if (hs.contains(d)) best = maxOf(best, d)
            }
        }

        if (best == -1) return -1
        return ((best.toLong() * best.toLong()) % MOD).toInt()
    }
}