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
            TreeNode rightNode = null;
            // List<Integer> temp = new ArrayList<Integer>();

            while(len > 0) {
                TreeNode node = queue.poll();
                if(node != null){
                    // temp.add(node.val);
                    rightNode = node;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                len--;
            }

            if(rightNode != null){
                res.add(rightNode.val);
            }
            // addLastElementToRes(temp, res);
        }
        return res;
    }

    // private void addLastElementToRes(List<Integer> temp, List<Integer> res) {
    //     int len = temp.size();

    //     while(len > 0){
    //         if(temp.get(len - 1) != null) {
    //             res.add(temp.get(len-1));
    //             break;
    //         }
    //         len--;
    //     }
    // }
}