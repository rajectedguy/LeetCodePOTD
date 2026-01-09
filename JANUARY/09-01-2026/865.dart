class Solution {
  TreeNode? subtreeWithAllDeepest(TreeNode? root) {
    List dfs(TreeNode? node) {
      if (node == null) return [0, null];
      var l = dfs(node.left);
      var r = dfs(node.right);
      if (l[0] > r[0]) return [l[0] + 1, l[1]];
      if (r[0] > l[0]) return [r[0] + 1, r[1]];
      return [l[0] + 1, node];
    }

    return dfs(root)[1];
  }
}