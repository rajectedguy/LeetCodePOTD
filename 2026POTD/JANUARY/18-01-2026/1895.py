from typing import List

class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        rowSum = [[0]*(n+1) for _ in range(m)]
        colSum = [[0]*n for _ in range(m+1)]
        diag1 = [[0]*(n+1) for _ in range(m+1)]  
        diag2 = [[0]*(n+1) for _ in range(m+1)]  

        for i in range(m):
            for j in range(n):
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j]
                colSum[i+1][j] = colSum[i][j] + grid[i][j]
                diag1[i+1][j+1] = diag1[i][j] + grid[i][j]
                diag2[i+1][j] = diag2[i][j+1] + grid[i][j]

        maxK = min(m, n)
        for k in range(maxK, 0, -1):
            for i in range(m - k + 1):
                for j in range(n - k + 1):
                    d1 = diag1[i+k][j+k] - diag1[i][j]
                    d2 = diag2[i+k][j] - diag2[i][j+k]
                    if d1 != d2:
                        continue
                    ok = True
                    for x in range(k):
                        rsum = rowSum[i+x][j+k] - rowSum[i+x][j]
                        csum = colSum[i+k][j+x] - colSum[i][j+x]
                        if rsum != d1 or csum != d1:
                            ok = False
                            break
                    if ok:
                        return k
        return 1