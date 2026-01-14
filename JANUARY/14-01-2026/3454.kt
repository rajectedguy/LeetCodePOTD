class Solution {
    fun separateSquares(squares: Array<IntArray>): Double {
        val n = squares.size

        val xs = ArrayList<Long>(2 * n)
        data class Event(val y: Long, val x1: Long, val x2: Long, val t: Int)
        val events = ArrayList<Event>(2 * n)

        for (s in squares) {
            val x = s[0].toLong()
            val y = s[1].toLong()
            val l = s[2].toLong()
            xs.add(x)
            xs.add(x + l)
            events.add(Event(y, x, x + l, 1))
            events.add(Event(y + l, x, x + l, -1))
        }

        xs.sort()
        val uniq = ArrayList<Long>()
        for (v in xs) {
            if (uniq.isEmpty() || uniq.last() != v) uniq.add(v)
        }

        val m = uniq.size
        val idx = HashMap<Long, Int>(m)
        for (i in 0 until m) idx[uniq[i]] = i

        val cnt = LongArray(4 * m)
        val seglen = LongArray(4 * m)

        fun upd(i: Int, l: Int, r: Int, ql: Int, qr: Int, v: Int) {
            if (qr <= l || r <= ql) return
            if (ql <= l && r <= qr) {
                cnt[i] += v.toLong()
            } else {
                val mid = (l + r) shr 1
                upd(i shl 1, l, mid, ql, qr, v)
                upd(i shl 1 or 1, mid, r, ql, qr, v)
            }
            seglen[i] = if (cnt[i] > 0) {
                uniq[r] - uniq[l]
            } else if (l + 1 == r) {
                0
            } else {
                seglen[i shl 1] + seglen[i shl 1 or 1]
            }
        }

        events.sortBy { it.y }

        var prev = events[0].y
        var total = 0.0
        var i = 0

        while (i < events.size) {
            val y = events[i].y
            val dy = y - prev
            if (dy > 0 && seglen[1] > 0) {
                total += seglen[1].toDouble() * dy.toDouble()
            }
            while (i < events.size && events[i].y == y) {
                val e = events[i]
                upd(1, 0, m, idx[e.x1]!!, idx[e.x2]!!, e.t)
                i++
            }
            prev = y
        }

        val half = total / 2.0
        java.util.Arrays.fill(cnt, 0)
        java.util.Arrays.fill(seglen, 0)

        prev = events[0].y
        var cur = 0.0
        i = 0

        while (i < events.size) {
            val y = events[i].y
            val dy = y - prev
            if (dy > 0 && seglen[1] > 0) {
                val area = seglen[1].toDouble() * dy.toDouble()
                if (cur + area >= half) {
                    return prev.toDouble() + (half - cur) / seglen[1].toDouble()
                }
                cur += area
            }
            while (i < events.size && events[i].y == y) {
                val e = events[i]
                upd(1, 0, m, idx[e.x1]!!, idx[e.x2]!!, e.t)
                i++
            }
            prev = y
        }

        return prev.toDouble()
    }
}