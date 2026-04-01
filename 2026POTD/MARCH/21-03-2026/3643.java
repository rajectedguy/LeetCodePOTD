class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int j=y;j<y+k;j++){
            int s = x;
            int e= x+k-1;
            while(s<e){
                int num = grid[s][j];
                grid[s][j]= grid[e][j];
                grid[e][j]=num;
                s++;
                e--;
            }
        }
        return grid;
    }
}