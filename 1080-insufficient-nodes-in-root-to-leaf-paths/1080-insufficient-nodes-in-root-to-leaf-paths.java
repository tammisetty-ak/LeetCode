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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return helper(root, limit, 0);
    }

    private TreeNode helper(TreeNode root, int limit, int sum) {
        if(root == null) {
            return null;
        }

        sum += root.val;

        if(root.left == null && root.right == null) {
            return sum < limit ? null : root;
        }

        root.left = helper(root.left, limit, sum);
        root.right = helper(root.right, limit, sum);

        return root.left == null && root.right == null ? null : root;
    }
}