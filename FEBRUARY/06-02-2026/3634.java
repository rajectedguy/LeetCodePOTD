class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int wlen = 0;
        for(int r = 0; r < nums.length; r++){
            while((long)nums[r] > (long)nums[l]*k){
                l++;
            }
            if(wlen < r-l+1){
                wlen = r-l+1;
            }
        }
        return nums.length - wlen;
    }
}