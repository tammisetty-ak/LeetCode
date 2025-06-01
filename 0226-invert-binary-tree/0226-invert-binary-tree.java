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

    // public Queue<TreeNode> printTree(TreeNode root){
        
    // }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll(); // 4 7 2 9 6 
            // if(node.left != null && node.right != null){ // 2 7 6 9 1 3 
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                // queue.add(node.left); // 4 7 2 9 6 3 1
                // queue.add(node.right);
            // }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

        return root;
    }
}