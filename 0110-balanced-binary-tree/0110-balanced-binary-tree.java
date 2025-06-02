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

    private int isBalancedHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = isBalancedHelper(root.left) + 1;
        int right = isBalancedHelper(root.right) + 1;
        if(left == 0 || right == 0 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }
}