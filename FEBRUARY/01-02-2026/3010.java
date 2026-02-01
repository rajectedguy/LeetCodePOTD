class Solution {

    public int minimumCost(int[] nums) {
        int firstMin = Math.min(nums[1], nums[2]);
        int secondMin = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            if (nums[i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }

        return nums[0] + firstMin + secondMin;
    }
}