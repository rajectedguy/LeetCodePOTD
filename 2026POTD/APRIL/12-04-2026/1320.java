class Solution {
    int[][] key={{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},
                      {1,0},{1,1},{1,2},{1,3},{1,4},{1,5},
                      {2,0},{2,1},{2,2},{2,3},{2,4},{2,5},
                      {3,0},{3,1},{3,2},{3,3},{3,4},{3,5},
                      {4,0},{4,1}};
    int n;
    public int getDistance(int from,int to){
        if(from==26)
            return 0;
        
        int[] x=key[from];
        int[] y=key[to];

        return Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
    }
    Integer dp[][][];
    public int solve(String word,int index,int f1,int f2) {
        if(index==n)
            return 0;
        
        if(dp[index][f1][f2]!=null)
            return dp[index][f1][f2];

        int nextFinger=word.charAt(index)-'A';
        
        int typeF1=getDistance(f1,nextFinger)+solve(word,index+1,nextFinger,f2);
        int typeF2=getDistance(f2,nextFinger)+solve(word,index+1,f1,nextFinger);

        return dp[index][f1][f2]=Math.min(typeF1,typeF2);
        
    }
    public int minimumDistance(String word) {
        n=word.length();
        dp=new Integer[n][27][27];
        return solve(word,0,26,26);
    }
}