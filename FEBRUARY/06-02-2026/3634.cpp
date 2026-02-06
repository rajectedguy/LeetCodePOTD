class Solution {
public:
    int minRemoval(vector<int>& nums, int k) {
        ranges::sort(nums);
        int n = nums.size(), maxLen = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (nums[i] > 1LL * k * nums[j])
                j++;
            maxLen = max(maxLen, (i - j + 1));
        }
        return n - maxLen;
    }
};