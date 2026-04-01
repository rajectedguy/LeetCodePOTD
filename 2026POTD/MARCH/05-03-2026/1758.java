class Solution {
    public int minOperations(String s) {
        StringBuilder sb=new StringBuilder(s);
        int steps=0;
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i-1)==sb.charAt(i) && sb.charAt(i)=='1'){
                sb.setCharAt(i,'0');
                steps++;
            }else if(sb.charAt(i-1)==sb.charAt(i) && sb.charAt(i)=='0'){
                sb.setCharAt(i,'1');
                steps++;
            }

        }
        return Math.min(steps,sb.length()-steps);
    }
}