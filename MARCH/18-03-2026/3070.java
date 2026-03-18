class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;

        int col[] = new int[c];
        int res =0;

        for(int i=0;i<r;i++){
            int sum =0;
            for(int j=0;j<c;j++){
                col[j]+= grid[i][j];
                sum += col[j];
                if(sum<=k)
                res++;
            }
        }
        return res;

    }
}