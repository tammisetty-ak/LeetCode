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

    int moves;

    private int distributeCoinsHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftCoins = distributeCoinsHelper(root.left);
        int rightCoins = distributeCoinsHelper(root.right);

        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        return root.val - 1 + leftCoins + rightCoins;
    }
    public int distributeCoins(TreeNode root) {
        moves = 0;
        distributeCoinsHelper(root);
        return moves;
    }
}