class Solution {
    func maximalRectangle(_ matrix: [[Character]]) -> Int {
        if matrix.isEmpty { return 0 }

        let cols = matrix[0].count
        var heights = Array(repeating: 0, count: cols)
        var ans = 0

        for row in matrix {
            for j in 0..<cols {
                heights[j] = row[j] == "1" ? heights[j] + 1 : 0
            }

            var stack: [Int] = []
            for i in 0...cols {
                let h = (i == cols) ? 0 : heights[i]
                while !stack.isEmpty && h < heights[stack.last!] {
                    let height = heights[stack.removeLast()]
                    let width = stack.isEmpty ? i : i - stack.last! - 1
                    ans = max(ans, height * width)
                }
                stack.append(i)
            }
        }

        return ans
    }
}