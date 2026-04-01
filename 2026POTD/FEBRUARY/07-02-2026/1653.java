class Solution {
    public int minimumDeletions(String s) {

        int ans=0;
           int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                count++;
            }
            if(s.charAt(i)=='a' && count>0){
                count--;
                ans++;
            }
            
             
        }
        return ans;
    }
}