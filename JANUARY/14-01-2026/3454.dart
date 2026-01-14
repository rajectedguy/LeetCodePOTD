class Solution {
  double separateSquares(List<List<int>> squares) {
    final n = squares.length;
    final xs = <int>[];
    final events = <List<dynamic>>[];

    for (var s in squares) {
      final x = s[0];
      final y = s[1];
      final l = s[2];
      xs.add(x);
      xs.add(x + l);
      events.add([y, x, x + l, 1]);
      events.add([y + l, x, x + l, -1]);
    }

    xs.sort();
    final uniq = <int>[];
    for (var v in xs) {
      if (uniq.isEmpty || uniq.last != v) uniq.add(v);
    }
    final m = uniq.length;
    final idx = <int, int>{};
    for (var i = 0; i < m; i++) idx[uniq[i]] = i;

    final cnt = List<int>.filled(4 * m, 0);
    final seglen = List<int>.filled(4 * m, 0);

    void upd(int i, int l, int r, int ql, int qr, int v) {
      if (qr <= l || r <= ql) return;
      if (ql <= l && r <= qr) {
        cnt[i] += v;
      } else {
        final mid = (l + r) >> 1;
        upd(i << 1, l, mid, ql, qr, v);
        upd(i << 1 | 1, mid, r, ql, qr, v);
      }
      if (cnt[i] > 0) {
        seglen[i] = uniq[r] - uniq[l];
      } else if (l + 1 == r) {
        seglen[i] = 0;
      } else {
        seglen[i] = seglen[i << 1] + seglen[i << 1 | 1];
      }
    }

    events.sort((a, b) => a[0].compareTo(b[0]));

    var prev = events[0][0] as int;
    double total = 0.0;
    var i = 0;

    while (i < events.length) {
      final y = events[i][0] as int;
      final dy = y - prev;
      if (dy > 0 && seglen[1] > 0) total += seglen[1] * dy.toDouble();

      while (i < events.length && events[i][0] == y) {
        final e = events[i];
        upd(1, 0, m, idx[e[1]]!, idx[e[2]]!, e[3] as int);
        i++;
      }
      prev = y;
    }

    final half = total / 2.0;
    for (var j = 0; j < cnt.length; j++) cnt[j] = 0;
    for (var j = 0; j < seglen.length; j++) seglen[j] = 0;

    prev = events[0][0] as int;
    double cur = 0.0;
    i = 0;

    while (i < events.length) {
      final y = events[i][0] as int;
      final dy = y - prev;
      if (dy > 0 && seglen[1] > 0) {
        final area = seglen[1] * dy.toDouble();
        if (cur + area >= half) return prev + (half - cur) / seglen[1];
        cur += area;
      }

      while (i < events.length && events[i][0] == y) {
        final e = events[i];
        upd(1, 0, m, idx[e[1]]!, idx[e[2]]!, e[3] as int);
        i++;
      }
      prev = y;
    }

    return prev.toDouble();
  }
}