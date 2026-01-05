class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int neg = 0;
        int mn = Integer.MAX_VALUE;
        for (int[] r : matrix) {
            for (int x : r) {
                if (x < 0) neg++;
                sum += Math.abs((long)x);
                mn = Math.min(mn, Math.abs(x));
            }
        }
        if ((neg & 1) == 1) sum -= 2L * mn;
        return sum;
    }
}