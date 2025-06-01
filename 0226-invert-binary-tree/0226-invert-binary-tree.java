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
    private void invertTreeHelper(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        invertTreeHelper(node.left);
        invertTreeHelper(node.right);
    }
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }
}