class Solution {
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        fun dfs(node: TreeNode?): Pair<Int, TreeNode?> {
            if (node == null) return Pair(0, null)
            val (ld, ln) = dfs(node.left)
            val (rd, rn) = dfs(node.right)
            return when {
                ld > rd -> Pair(ld + 1, ln)
                rd > ld -> Pair(rd + 1, rn)
                else -> Pair(ld + 1, node)
            }
        }
        return dfs(root).second
    }
}