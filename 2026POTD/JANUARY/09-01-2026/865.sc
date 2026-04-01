object Solution {
    def subtreeWithAllDeepest(root: TreeNode): TreeNode = {
        def dfs(node: TreeNode): (Int, TreeNode) = {
            if (node == null) return (0, null)
            val (ld, ln) = dfs(node.left)
            val (rd, rn) = dfs(node.right)
            if (ld > rd) return (ld + 1, ln)
            if (rd > ld) return (rd + 1, rn)
            (ld + 1, node)
        }
        dfs(root)._2
    }
}