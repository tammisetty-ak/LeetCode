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
    private int diameter = 0;
    private int diameterHelper(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int left = diameterHelper(root.left) + 1;
        int right = diameterHelper(root.right) + 1;
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return diameter;
    }
}