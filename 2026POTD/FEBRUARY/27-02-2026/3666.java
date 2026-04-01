class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int z = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') z++;
        }

        if (z == 0) return 0;
        if (k > n) return -1;

        for (int t = 1; t <= n; t++) {

            int totalFlips = t * k;

            if (totalFlips < z) continue;

            if ((totalFlips - z) % 2 != 0) continue;

            int maxOdd = (t % 2 == 1) ? t : t - 1;
            int maxEven = (t % 2 == 0) ? t : t - 1;

            long maxCapacity = (long) z * maxOdd
                             + (long) (n - z) * maxEven;

            if (totalFlips <= maxCapacity) {
                return t;
            }
        }

        return -1;
    }
}