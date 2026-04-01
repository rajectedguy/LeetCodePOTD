class Solution {
  int minimumDifference(List<int> nums, int k) {
    if (k <= 1) return 0;
    nums.sort();
    int ans = 1 << 30;
    for (int i = 0; i + k - 1 < nums.length; i++) {
      ans = ans < nums[i + k - 1] - nums[i]
          ? ans
          : nums[i + k - 1] - nums[i];
    }
    return ans;
  }
}