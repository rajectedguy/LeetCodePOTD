class Solution {
    func maxMatrixSum(_ matrix: [[Int]]) -> Int {
        var sum = 0
        var neg = 0
        var mn = Int.max
        for row in matrix {
            for x in row {
                if x < 0 { neg += 1 }
                let ax = abs(x)
                sum += ax
                mn = min(mn, ax)
            }
        }
        if neg % 2 == 1 {
            sum -= 2 * mn
        }
        return sum
    }
}