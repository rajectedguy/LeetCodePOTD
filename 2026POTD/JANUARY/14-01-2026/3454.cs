public class Solution {
    public double SeparateSquares(int[][] squares) {
        int n = squares.Length;
        long[] xs = new long[2 * n];
        long[][] events = new long[2 * n][];
        for (int i = 0; i < n; i++) {
            long x = squares[i][0], y = squares[i][1], l = squares[i][2];
            xs[2 * i] = x;
            xs[2 * i + 1] = x + l;
            events[2 * i] = new long[] { y, x, x + l, 1 };
            events[2 * i + 1] = new long[] { y + l, x, x + l, -1 };
        }

        Array.Sort(xs);
        int m = 0;
        for (int i = 0; i < xs.Length; i++) {
            if (i == 0 || xs[i] != xs[i - 1]) xs[m++] = xs[i];
        }

        Array.Sort(events, (a, b) => a[0].CompareTo(b[0]));

        long[] cnt = new long[4 * m];
        long[] len = new long[4 * m];

        void Update(int i, int l, int r, int ql, int qr, long v) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                cnt[i] += v;
            } else {
                int mid = (l + r) >> 1;
                Update(i << 1, l, mid, ql, qr, v);
                Update(i << 1 | 1, mid, r, ql, qr, v);
            }
            if (cnt[i] > 0) len[i] = xs[r] - xs[l];
            else if (l + 1 == r) len[i] = 0;
            else len[i] = len[i << 1] + len[i << 1 | 1];
        }

        long prevY = events[0][0];
        double total = 0;
        int idxEv = 0;

        while (idxEv < events.Length) {
            long y = events[idxEv][0];
            long dy = y - prevY;
            if (dy > 0 && len[1] > 0) total += len[1] * dy;
            while (idxEv < events.Length && events[idxEv][0] == y) {
                int l = Array.BinarySearch(xs, 0, m, events[idxEv][1]);
                int r = Array.BinarySearch(xs, 0, m, events[idxEv][2]);
                Update(1, 0, m - 1, l, r, events[idxEv][3]);
                idxEv++;
            }
            prevY = y;
        }

        double half = total / 2.0;
        Array.Clear(cnt, 0, cnt.Length);
        Array.Clear(len, 0, len.Length);

        prevY = events[0][0];
        double cur = 0;
        idxEv = 0;

        while (idxEv < events.Length) {
            long y = events[idxEv][0];
            long dy = y - prevY;
            if (dy > 0 && len[1] > 0) {
                double area = len[1] * dy;
                if (cur + area >= half)
                    return prevY + (half - cur) / len[1];
                cur += area;
            }
            while (idxEv < events.Length && events[idxEv][0] == y) {
                int l = Array.BinarySearch(xs, 0, m, events[idxEv][1]);
                int r = Array.BinarySearch(xs, 0, m, events[idxEv][2]);
                Update(1, 0, m - 1, l, r, events[idxEv][3]);
                idxEv++;
            }
            prevY = y;
        }

        return prevY;
    }
}