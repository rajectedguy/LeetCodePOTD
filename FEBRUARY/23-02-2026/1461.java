class Solution {
    public boolean hasAllCodes(String s, int k) {

        if (s.length() < k)
            return false;

        int unique = 1 << k;
        HashSet<String> set = new HashSet();
        for (int i = k; i <= s.length(); i++) {
            String sub = s.substring(i - k, i);

            if (!set.contains(sub)) {
                set.add(sub);
                unique--;
            }
            if (unique == 0)
                return true;
        }
        return false;
    }
}