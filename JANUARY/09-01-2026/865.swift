class Solution {
    func subtreeWithAllDeepest(_ root: TreeNode?) -> TreeNode? {
        func dfs(_ node: TreeNode?) -> (Int, TreeNode?) {
            guard let node = node else { return (0, nil) }
            let (ld, ln) = dfs(node.left)
            let (rd, rn) = dfs(node.right)
            if ld > rd { return (ld + 1, ln) }
            if rd > ld { return (rd + 1, rn) }
            return (ld + 1, node)
        }
        return dfs(root).1
    }
}