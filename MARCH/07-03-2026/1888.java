class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;

        int diff1 = 0, diff2 = 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 2 * n; i++) {
            char c = t.charAt(i);

            char p1 = (i % 2 == 0) ? '0' : '1';
            char p2 = (i % 2 == 0) ? '1' : '0';

            if (c != p1) diff1++;
            if (c != p2) diff2++;

            if (i >= n) {
                char prev = t.charAt(i - n);

                char pp1 = ((i - n) % 2 == 0) ? '0' : '1';
                char pp2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (prev != pp1) diff1--;
                if (prev != pp2) diff2--;
            }

            if (i >= n - 1) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}