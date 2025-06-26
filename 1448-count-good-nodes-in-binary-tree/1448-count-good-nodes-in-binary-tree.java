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
    int good;

    private void dfs(TreeNode root, int maxVal) {
        if(root == null) {
            return;
        }
        maxVal = Math.max(root.val, maxVal);
        if(maxVal <= root.val) {
            good++;
        }
        dfs(root.left, maxVal);
        dfs(root.right, maxVal);

    }

    public int goodNodes(TreeNode root) {
        good = 0;
        int maxVal = root.val;
        dfs(root, maxVal);
        return good;
    }
}