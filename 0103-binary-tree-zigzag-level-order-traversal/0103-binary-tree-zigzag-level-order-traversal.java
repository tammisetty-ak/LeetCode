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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        boolean isZigZag = true;
        List<List<Integer>> res = new ArrayList();

        while (!queue.isEmpty()) {
            int len = queue.size();
            isZigZag = !isZigZag;
            List<Integer> temp = new ArrayList();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    temp.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(!temp.isEmpty()) {
                if(!isZigZag) {
                    res.add(temp);
                }
                else {
                    Collections.reverse(temp);
                    res.add(temp);
                }
            }
        }

        return res;
    }
}