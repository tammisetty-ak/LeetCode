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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        List<Integer> res = new ArrayList();

        while(!queue.isEmpty()) {
            int len = queue.size();
            int right = -1;
            while(len-- > 0) {
                TreeNode tempNode = queue.poll();
                if(tempNode != null) {
                    right = tempNode.val;
                    queue.offer(tempNode.left);
                    queue.offer(tempNode.right);
                }
            }
            if(right != -1) {
                res.add(right);
            }
        }
        return res;
    }
}