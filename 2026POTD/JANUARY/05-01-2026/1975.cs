public class Solution {
    public long MaxMatrixSum(int[][] matrix) {
        long sum = 0;
        int neg = 0;
        int mn = int.MaxValue;
        foreach (var row in matrix) {
            foreach (var x in row) {
                if (x < 0) neg++;
                sum += Math.Abs((long)x);
                mn = Math.Min(mn, Math.Abs(x));
            }
        }
        if ((neg & 1) == 1) sum -= 2L * mn;
        return sum;
    }
}