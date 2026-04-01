class Solution {
  int maxLevelSum(TreeNode? root) {
    List<TreeNode> q = [root!];
    int level = 1, ans = 1;
    int maxSum = -1 << 60;

    while (q.isNotEmpty) {
      int size = q.length;
      int sum = 0;

      for (int i = 0; i < size; i++) {
        TreeNode node = q.removeAt(0);
        sum += node.val;
        if (node.left != null) q.add(node.left!);
        if (node.right != null) q.add(node.right!);
      }

      if (sum > maxSum) {
        maxSum = sum;
        ans = level;
      }
      level++;
    }
    return ans;
  }
}