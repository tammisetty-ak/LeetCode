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
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            Integer temp = null;
            while(len > 0){
                TreeNode node = queue.poll();
                if(node != null) {
                    temp = node.val;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                len--;
            }
            if(temp != null) {
                res.add(temp);
            }
        }
        return res;
    }
}