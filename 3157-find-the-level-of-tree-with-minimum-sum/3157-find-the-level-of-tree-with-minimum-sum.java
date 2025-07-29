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

    public int minimumLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        int level = 0; 

        int resLevel = 0;

        long minSum = Integer.MAX_VALUE;  


        while(!queue.isEmpty()) {
            int len = queue.size();
            long sum = 0;
            level++;

            while(len-- > 0) {
                TreeNode node = queue.poll();
                                    sum += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }
            }

            if(sum != 0 && sum < minSum) {
                minSum = sum;
                resLevel = level;
            }
        }

        return resLevel;

    }
}