class Solution {
    public String reverse(String str){
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString();
    }
    public String invert(String s){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')str.append('1');
            else str.append('0');
        }
        return str.toString();
    }
    public String construct(int n){
        if(n==0)return "0";
        return construct(n-1)+"1"+reverse(invert(construct(n-1)));
    }
    public char findKthBit(int n, int k) {
        String s= construct(n);
        return s.charAt(k-1);
    }
}