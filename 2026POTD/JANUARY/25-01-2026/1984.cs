public class Solution {
    public int MinimumDifference(int[] nums, int k) {
        if (k <= 1) return 0;
        Array.Sort(nums);
        int ans = int.MaxValue;
        for (int i = 0; i + k - 1 < nums.Length; i++) {
            ans = Math.Min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}