public class Solution {
    public int MinPairSum(int[] nums) {
        Array.Sort(nums);
        int i = 0, j = nums.Length - 1, ans = 0;
        while (i < j) {
            ans = Math.Max(ans, nums[i] + nums[j]);
            i++;
            j--;
        }
        return ans;
    }
}