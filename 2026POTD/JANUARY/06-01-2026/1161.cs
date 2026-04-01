public class Solution {
    public int MaxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new Queue<TreeNode>();
        q.Enqueue(root);
        int level = 1, ans = 1;
        long maxSum = long.MinValue;

        while (q.Count > 0) {
            int size = q.Count;
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.Dequeue();
                sum += node.val;
                if (node.left != null) q.Enqueue(node.left);
                if (node.right != null) q.Enqueue(node.right);
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