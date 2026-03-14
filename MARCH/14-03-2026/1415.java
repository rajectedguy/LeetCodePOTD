class Solution {
    int count;
    String ans;

    public String getHappyString(int n, int k) {
        this.count=k;
        this.ans="";
        String s="abc";
        solve(s,"",n,k);
        return ans;
    }
    public void solve(String s,String temp,int n,int k){
        if(n==0){
            count--;
            if(count==0){
                ans=temp;
            }
            return;
        }
        for(int i=0;i<3;i++){
            if(temp.length()==0 || temp.charAt(temp.length()-1)!=s.charAt(i)){
                solve(s,temp+s.charAt(i),n-1,k);
                if(count==0){
                    return;
                }
            }
        }
    }
}