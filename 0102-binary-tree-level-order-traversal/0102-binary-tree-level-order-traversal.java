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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        List<List<Integer>> res = new ArrayList();

        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> temp = new ArrayList();

            while(len-- > 0) {
                TreeNode tempNode = queue.poll();
                if(tempNode != null) {
                    temp.add(tempNode.val);
                    queue.offer(tempNode.left);
                    queue.offer(tempNode.right);
                }
            }
            if(temp.size() > 0)
                res.add(temp);
        }

        return res;
    }
}