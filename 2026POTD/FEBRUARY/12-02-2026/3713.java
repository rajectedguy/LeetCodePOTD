class Solution {
    public int longestBalanced(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> map=new HashMap<>();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(balance(map)){
                max=Math.max(max,j-i+1);
            }
            }

        }
        return max;
    }
    public static boolean balance(Map<Character,Integer> freq){
        Set<Integer> set=new HashSet<>(freq.values());
        return set.size()==1;
    }
}  