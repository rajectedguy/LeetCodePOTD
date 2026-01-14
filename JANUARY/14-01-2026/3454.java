class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        long[] xs = new long[2 * n];
        long[][] events = new long[2 * n][4];
        for (int i = 0; i < n; i++) {
            long x = squares[i][0], y = squares[i][1], l = squares[i][2];
            xs[2 * i] = x;
            xs[2 * i + 1] = x + l;
            events[2 * i] = new long[]{y, x, x + l, 1};
            events[2 * i + 1] = new long[]{y + l, x, x + l, -1};
        }
        java.util.Arrays.sort(xs);
        int m = 0;
        for (int i = 0; i < xs.length; i++) {
            if (i == 0 || xs[i] != xs[i - 1]) xs[m++] = xs[i];
        }
        long[] cnt = new long[4 * m];
        long[] len = new long[4 * m];
        java.util.Arrays.sort(events, java.util.Comparator.comparingLong(a -> a[0]));
        class Seg {
            void upd(int node, int l, int r, int ql, int qr, long v) {
                if (qr <= l || r <= ql) return;
                if (ql <= l && r <= qr) cnt[node] += v;
                else {
                    int mid = (l + r) >> 1;
                    upd(node << 1, l, mid, ql, qr, v);
                    upd(node << 1 | 1, mid, r, ql, qr, v);
                }
                if (cnt[node] > 0) len[node] = xs[r] - xs[l];
                else if (l + 1 == r) len[node] = 0;
                else len[node] = len[node << 1] + len[node << 1 | 1];
            }
        }
        Seg seg = new Seg();
        long prevY = events[0][0];
        double total = 0;
        for (int i = 0; i < events.length; ) {
            long y = events[i][0];
            long dy = y - prevY;
            if (dy > 0 && len[1] > 0) total += (double) len[1] * dy;
            while (i < events.length && events[i][0] == y) {
                int l = java.util.Arrays.binarySearch(xs, 0, m, events[i][1]);
                int r = java.util.Arrays.binarySearch(xs, 0, m, events[i][2]);
                seg.upd(1, 0, m - 1, l, r, events[i][3]);
                i++;
            }
            prevY = y;
        }
        double half = total / 2.0;
        java.util.Arrays.fill(cnt, 0);
        java.util.Arrays.fill(len, 0);
        prevY = events[0][0];
        double cur = 0;
        for (int i = 0; i < events.length; ) {
            long y = events[i][0];
            long dy = y - prevY;
            if (dy > 0 && len[1] > 0) {
                double area = (double) len[1] * dy;
                if (cur + area >= half) return prevY + (half - cur) / len[1];
                cur += area;
            }
            while (i < events.length && events[i][0] == y) {
                int l = java.util.Arrays.binarySearch(xs, 0, m, events[i][1]);
                int r = java.util.Arrays.binarySearch(xs, 0, m, events[i][2]);
                seg.upd(1, 0, m - 1, l, r, events[i][3]);
                i++;
            }
            prevY = y;
        }
        return prevY;
    }
}