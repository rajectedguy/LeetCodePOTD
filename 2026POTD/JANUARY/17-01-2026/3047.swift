class Solution {
    func largestSquareArea(_ bottomLeft: [[Int]], _ topRight: [[Int]]) -> Int {
        let n = bottomLeft.count
        var ans = 0
        for i in 0..<n {
            for j in (i + 1)..<n {
                let x1 = max(bottomLeft[i][0], bottomLeft[j][0])
                let y1 = max(bottomLeft[i][1], bottomLeft[j][1])
                let x2 = min(topRight[i][0], topRight[j][0])
                let y2 = min(topRight[i][1], topRight[j][1])
                if x2 > x1 && y2 > y1 {
                    let side = min(x2 - x1, y2 - y1)
                    ans = max(ans, side * side)
                }
            }
        }
        return ans
    }
}