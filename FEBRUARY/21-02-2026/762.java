class Solution {
    public int countPrimeSetBits(int left, int right) {
        HashSet<Integer> set=new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);set.add(13);
        set.add(17);
        set.add(19);
       int ans=0;
       for(int i=left;i<=right;i++){
        if(set.contains(Integer.bitCount(i))){
            ans++;
        }
       }
       return ans;  
    }
}