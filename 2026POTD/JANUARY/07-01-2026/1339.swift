class Solution {
    private var total: Int64 = 0
    private var best: Int64 = 0
    private let MOD: Int64 = 1_000_000_007

    private func sum(_ node: TreeNode?) -> Int64 {
        guard let node = node else { return 0 }
        return Int64(node.val) + sum(node.left) + sum(node.right)
    }

    private func dfs(_ node: TreeNode?) -> Int64 {
        guard let node = node else { return 0 }
        let s = Int64(node.val) + dfs(node.left) + dfs(node.right)
        let prod = s * (total - s)
        if prod > best { best = prod }
        return s
    }

    func maxProduct(_ root: TreeNode?) -> Int {
        total = sum(root)
        dfs(root)
        return Int(best % MOD)
    }
}