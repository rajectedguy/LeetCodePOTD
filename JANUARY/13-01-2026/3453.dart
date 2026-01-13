class Solution {
  double separateSquares(List<List<int>> squares) {
    final events = <List<double>>[];

    for (final s in squares) {
      final y = s[1].toDouble();
      final l = s[2].toDouble();
      events.add([y, l]);
      events.add([y + l, -l]);
    }

    events.sort((a, b) => a[0].compareTo(b[0]));

    double curWidth = 0.0;
    double prevY = events[0][0];
    double totalArea = 0.0;
    final segments = <List<double>>[];

    for (final e in events) {
      final y = e[0];
      final delta = e[1];
      if (y > prevY && curWidth > 0) {
        final area = (y - prevY) * curWidth;
        segments.add([prevY, y, curWidth, area]);
        totalArea += area;
      }
      curWidth += delta;
      prevY = y;
    }

    final target = totalArea / 2.0;
    double acc = 0.0;

    for (final seg in segments) {
      final y1 = seg[0];
      final w = seg[2];
      final area = seg[3];
      if (acc + area >= target) {
        return y1 + (target - acc) / w;
      }
      acc += area;
    }

    return 0.0;
  }
}