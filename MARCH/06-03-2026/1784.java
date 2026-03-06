class Solution {
    public boolean checkOnesSegment(String s) {
        char ch[]=s.toCharArray();
        int ind=-1;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1'){
                if(i-ind>1) return false;
                ind=i;
            }
            
        }
        return true;
    }
}