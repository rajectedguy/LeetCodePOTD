int largestMagicSquare(int** grid, int gridSize, int* gridColSize) {
    int m = gridSize;
    int n = gridColSize[0];

    int rowSum[m][n+1];
    int colSum[m+1][n];
    int diag1[m+1][n+1];
    int diag2[m+1][n+1];

    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
            if (i < m && j < n) {
                rowSum[i][j+1] = 0;
                colSum[i][j] = 0;
            }
            diag1[i][j] = 0;
            diag2[i][j] = 0;
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
            colSum[i+1][j] = colSum[i][j] + grid[i][j];
            diag1[i+1][j+1] = diag1[i][j] + grid[i][j];
            diag2[i+1][j] = diag2[i][j+1] + grid[i][j];
        }
    }

    int maxK = m < n ? m : n;
    for (int k = maxK; k >= 1; k--) {
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int d1 = diag1[i+k][j+k] - diag1[i][j];
                int d2 = diag2[i+k][j] - diag2[i][j+k];
                if (d1 != d2) continue;

                int ok = 1;
                for (int x = 0; x < k; x++) {
                    int rsum = rowSum[i+x][j+k] - rowSum[i+x][j];
                    int csum = colSum[i+k][j+x] - colSum[i][j+x];
                    if (rsum != d1 || csum != d1) {
                        ok = 0;
                        break;
                    }
                }
                if (ok) return k;
            }
        }
    }

    return 1;
}