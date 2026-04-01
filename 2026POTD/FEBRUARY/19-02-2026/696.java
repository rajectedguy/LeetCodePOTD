class Solution {
    public int countBinarySubstrings(String s) {
        
        int n = s.length();
        int[] ans = new int[n];
        int count = 1;
        int idx = 0;

        for(int i = 0; i < n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                ++count;
            }
            else {
                ans[idx++] = count;
                count = 1;
            }
        }
        ans[idx++] = count;
        int res = 0;
        for(int i = 0; i < idx-1; i++) {
            res += Math.min(ans[i], ans[i+1]);
        }
        return res;
    }
}