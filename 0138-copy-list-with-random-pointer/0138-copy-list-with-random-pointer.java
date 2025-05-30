/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    Map<Node, Node> oldestToNewest = new HashMap();

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        if(oldestToNewest.containsKey(head)) {
            return oldestToNewest.get(head);
        }

        Node node = new Node(head.val);

        oldestToNewest.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}