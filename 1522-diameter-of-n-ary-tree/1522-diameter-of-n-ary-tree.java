/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    int diameter = 0;

    private int diameterHelper (Node root) {
        if(root.children.size() == 0) {
            return 0;
        }

        int maxH1 = 0, maxH2 = 0;

        for(Node child: root.children) {
            int parentH = diameterHelper(child) + 1 ;

            if(parentH > maxH1) {
                maxH2 = maxH1;
                maxH1 = parentH;
            }
            else if(parentH > maxH2) {
                maxH2 = parentH;
            }

            int dist = maxH1 + maxH2;

            diameter = Math.max(diameter, dist);
        }

        return maxH1;

    }
    public int diameter(Node root) {
        diameterHelper(root);
        return diameter;
    }
}