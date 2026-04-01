class Solution {
    func maxSideLength(_ mat: [[Int]], _ threshold: Int) -> Int {
        let m = mat.count
        let n = mat[0].count
        
        var prefix = Array(repeating: Array(repeating: 0, count: n + 1), count: m + 1)
        for i in 0..<m {
            for j in 0..<n {
                prefix[i + 1][j + 1] = mat[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j]
            }
        }
        
        var left = 0
        var right = min(m, n)
        var ans = 0
        
        while left <= right {
            let mid = (left + right) / 2
            var found = false
            
            outer: for i in mid...m {
                for j in mid...n {
                    let total = prefix[i][j] - prefix[i - mid][j] - prefix[i][j - mid] + prefix[i - mid][j - mid]
                    if total <= threshold {
                        found = true
                        break outer
                    }
                }
            }
            
            if found {
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return ans
    }
}