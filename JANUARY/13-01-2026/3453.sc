object Solution {
    def separateSquares(squares: Array[Array[Int]]): Double = {
        val events = scala.collection.mutable.ArrayBuffer[(Double, Double)]()

        for (s <- squares) {
            val y = s(1).toDouble
            val l = s(2).toDouble
            events.append((y, l))
            events.append((y + l, -l))
        }

        val sortedEvents = events.sortBy(_._1)

        var curWidth = 0.0
        var prevY = sortedEvents(0)._1
        var totalArea = 0.0
        val segments = scala.collection.mutable.ArrayBuffer[(Double, Double, Double, Double)]()

        for ((y, delta) <- sortedEvents) {
            if (y > prevY && curWidth > 0) {
                val area = (y - prevY) * curWidth
                segments.append((prevY, y, curWidth, area))
                totalArea += area
            }
            curWidth += delta
            prevY = y
        }

        val target = totalArea / 2.0
        var acc = 0.0
        var result = 0.0

        for ((y1, y2, w, area) <- segments if result == 0.0) { // stop once found
            if (acc + area >= target) {
                result = y1 + (target - acc) / w
            } else {
                acc += area
            }
        }

        result
    }
}