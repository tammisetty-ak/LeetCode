/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode res;

    private void TreeNodeHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return;
        }
        if(root.val >= p.val && root.val <= q.val) {
            res = root;
            return;
        }
        TreeNodeHelper(root.left, p, q);
        TreeNodeHelper(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        TreeNodeHelper(root, p, q);
        return res;
    }
}