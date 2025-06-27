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
    int index;
    int smallest;
    private void inorder(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        inorder(root.left, k);
        if(--index == 0) {
            smallest = root.val;
        }
        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        index = k;
        inorder(root, index);
        return smallest;    
    }
}