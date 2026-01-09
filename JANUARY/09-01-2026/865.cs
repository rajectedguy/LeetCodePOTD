public class Solution {
    private (int depth, TreeNode node) Dfs(TreeNode root) {
        if (root == null) return (0, null);
        var l = Dfs(root.left);
        var r = Dfs(root.right);
        if (l.depth > r.depth) return (l.depth + 1, l.node);
        if (r.depth > l.depth) return (r.depth + 1, r.node);
        return (l.depth + 1, root);
    }

    public TreeNode SubtreeWithAllDeepest(TreeNode root) {
        return Dfs(root).node;
    }
}