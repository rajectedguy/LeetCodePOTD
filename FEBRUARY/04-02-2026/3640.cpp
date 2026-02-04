
class Solution {
public:
    long long maxSumTrionic(vector<int>& nums) {
        int n = nums.size();
        int state=0;
        long long count[3]={0};
        long long ans = -1e14;
        count[0]=nums[0];
        for (int i=1; i<n; i++)
        {
            if(nums[i]==nums[i-1])
            {
                count[0] = nums[i];
                state = 0;
                continue;
            } 
            switch(state)
            {
                case 0:
                if(nums[i]>nums[i-1])
                {
                    count[0] += nums[i];
                     state=1;
                }
                else 
                {
                    count[0]=nums[i];
                }
                break;
                case 1:
                if(nums[i]<nums[i-1])
                {
                    count[1] = count[0] + nums[i]; // nums[i]+nums[i-1];
                    state=2;
                }
                else
                {
                    count[0]+=nums[i];
                    if (count[0]<nums[i]+nums[i-1])
                      count[0] = nums[i]+nums[i-1];
                }
                break;
                case 2:
                if(nums[i]>nums[i-1])
                {
                    count[2] = count[1] + nums[i]; // nums[i]+nums[i-1];
                    count[0] = nums[i] + nums[i-1];
                    ans = max(ans,count[2]);
                    state=3;
                }
                else
                {
                    count[1]+=nums[i];
                }
                break;

                case 3:
                if(nums[i]<nums[i-1])
                {
                    count[1] = count[0] + nums[i];
                    state=2;
                }
                else
                {
                    count[2]+=nums[i];
                    count[0]+=nums[i];
                    if (count[0]<nums[i]+nums[i-1])
                      count[0] = nums[i]+nums[i-1];
                    ans = max(ans,count[2]);
                }
                break;
            }
        }
        return ans;
    }
};