class Solution {
public:
    vector<int> constructTransformedArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, 0);

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int x = nums[i] % n;
                int idx = (i + x) % n;
                ans[i] = nums[idx];
            } else if (nums[i] < 0) {

                int x = abs(nums[i]);
                x = x % n;
                int idx = (i + abs(n - x)) % n;
                ans[i] = nums[idx];
            }
        }
        return ans;
    }
};