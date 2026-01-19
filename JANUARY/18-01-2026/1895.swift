class Solution {
    func largestMagicSquare(_ grid: [[Int]]) -> Int {
        let m = grid.count
        let n = grid[0].count

        var rowSum = Array(repeating: Array(repeating: 0, count: n+1), count: m)
        var colSum = Array(repeating: Array(repeating: 0, count: n), count: m+1)
        var diag1 = Array(repeating: Array(repeating: 0, count: n+1), count: m+1) // top-left → bottom-right
        var diag2 = Array(repeating: Array(repeating: 0, count: n+1), count: m+1) // top-right → bottom-left

        for i in 0..<m {
            for j in 0..<n {
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j]
                colSum[i+1][j] = colSum[i][j] + grid[i][j]
                diag1[i+1][j+1] = diag1[i][j] + grid[i][j]
                diag2[i+1][j] = diag2[i][j+1] + grid[i][j]
            }
        }

        let maxK = min(m, n)
        for k in stride(from: maxK, through: 1, by: -1) {
            for i in 0...m - k {
                for j in 0...n - k {
                    let d1 = diag1[i+k][j+k] - diag1[i][j]
                    let d2 = diag2[i+k][j] - diag2[i][j+k]
                    if d1 != d2 { continue }

                    var ok = true
                    for x in 0..<k {
                        let rsum = rowSum[i+x][j+k] - rowSum[i+x][j]
                        let csum = colSum[i+k][j+x] - colSum[i][j+x]
                        if rsum != d1 || csum != d1 {
                            ok = false
                            break
                        }
                    }
                    if ok { return k }
                }
            }
        }

        return 1
    }
}