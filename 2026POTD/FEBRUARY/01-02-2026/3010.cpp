class Solution {
public:
    int minimumCost(vector<int>& nums) {
        int a=nums[0];
        sort(nums.begin()+1,nums.end());
        int b=nums[1];
        int c=nums[2];
        return a+b+c;       
    }
};