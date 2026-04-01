/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
 void helper(TreeNode root, int[] sum, int count) {
        if (root == null)
            return;
        count = (count << 1) + root.val;
        if (root.left == null && root.right == null) {
            sum[0] += count;
            return;
        }
        helper(root.left, sum, count);
        helper(root.right, sum, count);
    }

    public int sumRootToLeaf(TreeNode root) {
        int[] sum = { 0 };
        int count = 0;
        helper(root, sum, count);
        return sum[0];
    }
}