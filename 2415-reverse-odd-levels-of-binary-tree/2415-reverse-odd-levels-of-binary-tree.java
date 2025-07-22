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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        boolean isOddLevel = false;

        int level = 0;

        while(!queue.isEmpty()) { // root // 2 3
            int size = queue.size(); // 1 // 2 // 4
            List<TreeNode> list = new ArrayList();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                list.add(node);

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            if(isOddLevel) {
                int left = 0, right = list.size() - 1;

                while(left < right) {
                    int temp = list.get(left).val;
                    list.get(left).val = list.get(right).val;
                    list.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            isOddLevel = !isOddLevel;
        }

        return root;
    }
}