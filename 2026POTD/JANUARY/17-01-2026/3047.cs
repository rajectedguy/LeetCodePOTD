public class Solution {
    public long LargestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.Length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = Math.Max(bottomLeft[i][0], bottomLeft[j][0]);
                int y1 = Math.Max(bottomLeft[i][1], bottomLeft[j][1]);
                int x2 = Math.Min(topRight[i][0], topRight[j][0]);
                int y2 = Math.Min(topRight[i][1], topRight[j][1]);
                if (x2 > x1 && y2 > y1) {
                    long side = Math.Min(x2 - x1, y2 - y1);
                    ans = Math.Max(ans, side * side);
                }
            }
        }
        return ans;
    }
}