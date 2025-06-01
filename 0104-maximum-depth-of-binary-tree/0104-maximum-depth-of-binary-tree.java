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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        if(root == null) {
            return 0;
        }

        int depth = 0;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            while(len > 0) {
                TreeNode curr = queue.poll();
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
                len--;
            }
        }
        return depth;
    }
}