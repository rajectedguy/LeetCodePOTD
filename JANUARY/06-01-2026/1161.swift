class Solution {
    func maxLevelSum(_ root: TreeNode?) -> Int {
        var q: [TreeNode] = [root!]
        var level = 1, ans = 1
        var maxSum = Int.min

        while !q.isEmpty {
            let size = q.count
            var sum = 0

            for _ in 0..<size {
                let node = q.removeFirst()
                sum += node.val
                if let left = node.left { q.append(left) }
                if let right = node.right { q.append(right) }
            }

            if sum > maxSum {
                maxSum = sum
                ans = level
            }
            level += 1
        }
        return ans
    }
}