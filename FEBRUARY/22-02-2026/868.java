class Solution {
    public int binaryGap(int n) {
        int cur = 0;
        int prev = -1;

        int res = 0;

        while (n > 0) {
            if ((n & 1) > 0) {
                res = prev != -1 ? Math.max(res, cur - prev) : res;
                prev = cur;
            }
            cur++;
            n >>= 1;
        }

        return res;
    }
}