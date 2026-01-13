public class Solution {
    public double SeparateSquares(int[][] squares) {
        double lo = 1e18, hi = -1e18;
        double total = 0.0;
        foreach (var s in squares) {
            double y = s[1], l = s[2];
            if (y < lo) lo = y;
            if (y + l > hi) hi = y + l;
            total += l * l;
        }
        double target = total / 2.0;
        for (int it = 0; it < 80; it++) {
            double mid = (lo + hi) * 0.5;
            double below = 0.0;
            foreach (var s in squares) {
                double y = s[1], l = s[2];
                if (mid > y) {
                    double h = mid - y;
                    if (h > l) h = l;
                    below += h * l;
                }
            }
            if (below < target) lo = mid;
            else hi = mid;
        }
        return lo;
    }
}