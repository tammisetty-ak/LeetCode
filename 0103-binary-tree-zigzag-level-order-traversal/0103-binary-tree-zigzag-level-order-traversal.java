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
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        boolean isZigZag = true;
        List<List<Integer>> res = new ArrayList();

        while (!queue.isEmpty()) {
            int len = queue.size();
            isZigZag = !isZigZag;
            LinkedList<Integer> temp = new LinkedList();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if(!isZigZag) {
                    temp.addLast(node.val);
                }
                else {
                    temp.addFirst(node.val);
                }
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(!temp.isEmpty()) {
               res.add(temp);
            }
        }

        return res;
    }
}