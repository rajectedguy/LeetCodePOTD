function largestMagicSquare(grid: number[][]): number {
    const m = grid.length, n = grid[0].length;

    const rowSum: number[][] = Array.from({length: m}, () => Array(n+1).fill(0));
    const colSum: number[][] = Array.from({length: m+1}, () => Array(n).fill(0));
    const diag1: number[][] = Array.from({length: m+1}, () => Array(n+1).fill(0));
    const diag2: number[][] = Array.from({length: m+1}, () => Array(n+1).fill(0));

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
            colSum[i+1][j] = colSum[i][j] + grid[i][j];
            diag1[i+1][j+1] = diag1[i][j] + grid[i][j];
            diag2[i+1][j] = diag2[i][j+1] + grid[i][j];
        }
    }

    const maxK = Math.min(m, n);
    for (let k = maxK; k >= 1; k--) {
        for (let i = 0; i <= m - k; i++) {
            for (let j = 0; j <= n - k; j++) {
                const d1 = diag1[i+k][j+k] - diag1[i][j];
                const d2 = diag2[i+k][j] - diag2[i][j+k];
                if (d1 !== d2) continue;

                let ok = true;
                for (let x = 0; x < k; x++) {
                    const rsum = rowSum[i+x][j+k] - rowSum[i+x][j];
                    const csum = colSum[i+k][j+x] - colSum[i][j+x];
                    if (rsum !== d1 || csum !== d1) {
                        ok = false;
                        break;
                    }
                }
                if (ok) return k;
            }
        }
    }

    return 1;
}