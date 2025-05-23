/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    List<Integer> res;
    
    private void preorderHelper(Node root) {
        if(root == null) {
            return;
        }
        
        res.add(root.val);
        List<Node> c = new ArrayList(root.children);
        for(Node k : c) {
            preorderHelper(k);
        }
    }
    
    public List<Integer> preorder(Node root) {
        res = new ArrayList();    
        preorderHelper(root);
        return res;
    }
}