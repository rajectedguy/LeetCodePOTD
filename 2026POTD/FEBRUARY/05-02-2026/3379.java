class Solution {

    int getNum(int[] nums, int i){
        int k = nums[i];

        if(k>0){
            int jumps = k%nums.length;
            if(i+jumps > nums.length-1){
                return nums[jumps-(nums.length-1-i)-1];
            }
            return nums[i+jumps];
        }
        else if(k<0){
            int jumps = Math.abs(k)%nums.length;
            if(i-jumps<0){
                return nums[nums.length-1-(jumps-i-1)];
            }
            return nums[i-jumps];
        }
        return nums[i];

    }

    public int[] constructTransformedArray(int[] nums) {

        int[] res = new int[nums.length];
        for(int i=0;i<res.length;i++){
            res[i]=getNum(nums,i);
        }
        return res;
        
    }
}