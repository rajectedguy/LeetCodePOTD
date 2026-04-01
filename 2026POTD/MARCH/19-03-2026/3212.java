class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] nums = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 'X') nums[i][j] = 1;
                else if(grid[i][j] == 'Y') nums[i][j] = -1;
                else nums[i][j] = 0;
            }
        }

        int [][] temp = new int[m][n];   // prefix sum (X - Y)
        int [][] freq = new int[m][n];   // prefix count of X

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                int val = nums[i][j];
                int xVal = (grid[i][j] == 'X') ? 1 : 0;

                if(i==0 && j==0){
                    temp[i][j] = val;
                    freq[i][j] = xVal;
                }
                else if(i==0){
                    temp[i][j] = temp[i][j-1] + val;
                    freq[i][j] = freq[i][j-1] + xVal;
                }
                else if(j==0){
                    temp[i][j] = temp[i-1][j] + val;
                    freq[i][j] = freq[i-1][j] + xVal;
                }
                else{
                    temp[i][j] = temp[i-1][j] + temp[i][j-1] - temp[i-1][j-1] + val;
                    freq[i][j] = freq[i-1][j] + freq[i][j-1] - freq[i-1][j-1] + xVal;
                }
            }
        } 

        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j] == 0 && freq[i][j] > 0){
                    count++;
                }
            }
        }

        return count;
    }
}