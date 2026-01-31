class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans=' ';
        int lb=0, ub=letters.length-1, mid;
        while(lb<=ub){
            mid=(lb+ub)/2;
            if(letters[mid]>target){
                ans=letters[mid];
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        if(ans==' ') return letters[0];
        return ans;
    }
}