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
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList();

        if(root == null) {
            return res;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
        int col = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap();

        queue.offer(new Pair(root, col));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int column = p.getValue();

            if(node != null) {
                map.putIfAbsent(column, new ArrayList<>());
                map.get(column).add(node.val);

                queue.offer(new Pair(node.left, column - 1));
                queue.offer(new Pair(node.right, column + 1));
            }
        }

        List<Integer> keys = new ArrayList(map.keySet());
        Collections.sort(keys);


        for(int m: keys) {
            res.add(map.get(m));
        }

        return res;
    }
}