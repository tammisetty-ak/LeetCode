/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }

        Node leftmost = root;

        while(leftmost.left != null) {
            Node head = leftmost;

            while(head != null) {
                if(head.left != null) {
                    if(head.right != null) {
                        head.left.next = head.right;
                    }
                    else {
                        if(head.next.left != null) {
                            head.left.next = head.next.left;
                        }
                        else {
                            head.left.next = head.next.right;
                        }
                    }

                }

                if(head.next != null) {
                    if(head.right != null)
                        head.right.next = head.next.right;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }
}