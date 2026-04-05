class Solution {
    public boolean judgeCircle(String moves) {
        int r = 0, l = 0, u = 0, d = 0;
        for (char c : moves.toCharArray()) {
            if      (c == 'R') r++;
            else if (c == 'L') l++;
            else if (c == 'U') u++;
            else               d++ ;
        }
        return r == l && u == d;
    }
}