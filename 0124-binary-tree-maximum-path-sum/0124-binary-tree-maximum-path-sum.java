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

    int maxSum = Integer.MIN_VALUE;

    private int pathSum(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        int left = Math.max(0, pathSum(root.left, sum));
        int right = Math.max(0, pathSum(root.right, sum));

        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left + root.val, right + root.val);

    }
    public int maxPathSum(TreeNode root) {
        int rootSum = pathSum(root, 0);
        return maxSum;
    }
}