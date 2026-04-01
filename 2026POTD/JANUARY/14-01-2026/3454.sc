object Solution {
    def separateSquares(squares: Array[Array[Int]]): Double = {
        val n = squares.length
        val xs = scala.collection.mutable.ArrayBuffer[Long]()
        case class Event(y: Long, x1: Long, x2: Long, t: Int)
        val events = scala.collection.mutable.ArrayBuffer[Event]()

        for (s <- squares) {
            val x = s(0).toLong
            val y = s(1).toLong
            val l = s(2).toLong
            xs += x
            xs += x + l
            events += Event(y, x, x + l, 1)
            events += Event(y + l, x, x + l, -1)
        }

        val uniq = xs.sorted.distinct
        val m = uniq.length
        val idx = uniq.zipWithIndex.toMap

        val cnt = Array.fill[Long](4 * m)(0L)
        val seglen = Array.fill[Long](4 * m)(0L)

        def upd(i: Int, l: Int, r: Int, ql: Int, qr: Int, v: Long): Unit = {
            if (qr <= l || r <= ql) return
            if (ql <= l && r <= qr) cnt(i) += v
            else {
                val mid = (l + r) >> 1
                upd(i << 1, l, mid, ql, qr, v)
                upd(i << 1 | 1, mid, r, ql, qr, v)
            }
            seglen(i) = if (cnt(i) > 0) uniq(r) - uniq(l)
            else if (l + 1 == r) 0L
            else seglen(i << 1) + seglen(i << 1 | 1)
        }

        val sortedEvents = events.sortBy(_.y)

        var prev = sortedEvents(0).y
        var total = 0.0
        var i = 0

        while (i < sortedEvents.length) {
            val y = sortedEvents(i).y
            val dy = y - prev
            if (dy > 0 && seglen(1) > 0) total += seglen(1).toDouble * dy.toDouble

            while (i < sortedEvents.length && sortedEvents(i).y == y) {
                val e = sortedEvents(i)
                upd(1, 0, m, idx(e.x1), idx(e.x2), e.t.toLong)
                i += 1
            }
            prev = y
        }

        val half = total / 2.0
        java.util.Arrays.fill(cnt, 0L)
        java.util.Arrays.fill(seglen, 0L)

        prev = sortedEvents(0).y
        var cur = 0.0
        i = 0

        while (i < sortedEvents.length) {
            val y = sortedEvents(i).y
            val dy = y - prev
            if (dy > 0 && seglen(1) > 0) {
                val area = seglen(1).toDouble * dy.toDouble
                if (cur + area >= half) return prev.toDouble + (half - cur)/seglen(1).toDouble
                cur += area
            }

            while (i < sortedEvents.length && sortedEvents(i).y == y) {
                val e = sortedEvents(i)
                upd(1, 0, m, idx(e.x1), idx(e.x2), e.t.toLong)
                i += 1
            }
            prev = y
        }

        prev.toDouble
    }
}