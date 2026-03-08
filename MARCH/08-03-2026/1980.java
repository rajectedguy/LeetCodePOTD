class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }

        return sb.toString();
    }
}