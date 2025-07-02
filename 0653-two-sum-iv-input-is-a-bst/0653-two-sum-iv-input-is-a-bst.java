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
    Set<Integer> set = new HashSet();
    boolean has = false;
    private void helper(TreeNode root, int k) {
        if(root == null || has) {
            return;
        }
        if(set.contains(k - root.val)) {
            has = true;
        }
        set.add(root.val);
        
        helper(root.left, k);
        helper(root.right, k);
    }
    public boolean findTarget(TreeNode root, int k) {
        helper(root, k);
        return has;
    }
}