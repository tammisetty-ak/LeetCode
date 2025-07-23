class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node current = root; // start with the root

        while (current != null) {
            Node dummy = new Node(0); // dummy node to build the next level
            Node tail = dummy; // tail tracks the last node in the next level

            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }

                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }

                current = current.next; // move to the next node in the current level
            }

            current = dummy.next; // move to the first node of the next level
        }

        return root;
    }
}
