func largestMagicSquare(grid [][]int) int {
    m, n := len(grid), len(grid[0])

    rowSum := make([][]int, m)
    colSum := make([][]int, m+1)
    diag1 := make([][]int, m+1)
    diag2 := make([][]int, m+1)

    for i := 0; i <= m; i++ {
        if i < m {
            rowSum[i] = make([]int, n+1)
            colSum[i] = make([]int, n)
        }
        diag1[i] = make([]int, n+1)
        diag2[i] = make([]int, n+1)
    }
    colSum[m] = make([]int, n)

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            rowSum[i][j+1] = rowSum[i][j] + grid[i][j]
            colSum[i+1][j] = colSum[i][j] + grid[i][j]
            diag1[i+1][j+1] = diag1[i][j] + grid[i][j]
            diag2[i+1][j] = diag2[i][j+1] + grid[i][j]
        }
    }

    maxK := m
    if n < m {
        maxK = n
    }

    for k := maxK; k >= 1; k-- {
        for i := 0; i <= m-k; i++ {
            for j := 0; j <= n-k; j++ {
                d1 := diag1[i+k][j+k] - diag1[i][j]
                d2 := diag2[i+k][j] - diag2[i][j+k]
                if d1 != d2 {
                    continue
                }
                ok := true
                for x := 0; x < k; x++ {
                    rsum := rowSum[i+x][j+k] - rowSum[i+x][j]
                    csum := colSum[i+k][j+x] - colSum[i][j+x]
                    if rsum != d1 || csum != d1 {
                        ok = false
                        break
                    }
                }
                if ok {
                    return k
                }
            }
        }
    }

    return 1
}