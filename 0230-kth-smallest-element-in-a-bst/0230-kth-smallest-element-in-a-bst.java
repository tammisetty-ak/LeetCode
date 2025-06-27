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
    int smallest;
    int[] temp;
    private void inorder(TreeNode root, int[] k) {
        if(root == null) {
            return;
        }
        inorder(root.left, temp);
        if(--temp[0] == 0) {
            temp[1] = root.val;
        }
        inorder(root.right, temp);
    }

    public int kthSmallest(TreeNode root, int k) {
        temp = new int[2];
        temp[0] = k;
        inorder(root, temp);
        return temp[1];    
    }
}