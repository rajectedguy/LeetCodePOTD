class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        boolean first = false;
        boolean second = false;
        boolean third = false;

        int i = 1;
        while(i < n){
            if(nums[i] > nums[i-1]){
                i++;
                first = true;
            }else{
                break;
            }
        }
        while(i < n){
            if(nums[i] < nums[i-1]){
                i++;
                second = true;
            }else{
                break;
            }
        }
        while(i < n){
            if(nums[i] > nums[i-1]){
                i++;
                third = true;
            }else{
                break;
            }
        }
        
        if(i == n){
            if(first && second && third){
                return true;
            }
        }
        return false;

        
    }
}