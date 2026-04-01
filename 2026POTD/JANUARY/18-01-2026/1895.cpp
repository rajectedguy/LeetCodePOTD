class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        
        vector<vector<int>> rowSum(m, vector<int>(n+1, 0));
        vector<vector<int>> colSum(m+1, vector<int>(n, 0));
        vector<vector<int>> diag1(m+1, vector<int>(n+1, 0));
        vector<vector<int>> diag2(m+1, vector<int>(n+1, 0));

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
                colSum[i+1][j] = colSum[i][j] + grid[i][j];
                diag1[i+1][j+1] = diag1[i][j] + grid[i][j];
                diag2[i+1][j] = diag2[i][j+1] + grid[i][j];
            }
        }

        int maxK = min(m,n);
        for(int k = maxK; k>=1; k--){
            for(int i=0;i<=m-k;i++){
                for(int j=0;j<=n-k;j++){
                    int d1 = diag1[i+k][j+k] - diag1[i][j];
                    int d2 = diag2[i+k][j] - diag2[i][j+k];
                    bool ok = true;
                    for(int x=0;x<k;x++){
                        int rsum = rowSum[i+x][j+k] - rowSum[i+x][j];
                        int csum = colSum[i+k][j+x] - colSum[i][j+x];
                        if(rsum != d1 || csum != d1){
                            ok = false;
                            break;
                        }
                    }
                    if(ok && d1==d2) return k;
                }
            }
        }
        return 1;
    }
};