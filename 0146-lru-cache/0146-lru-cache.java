class LRUCache {

    public class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head, tail;
    int capacity;
    HashMap<Integer, Node> keyNode;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        keyNode = new HashMap<Integer, Node>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyNode.containsKey(key)) {
            return -1;
        }
        Node node = keyNode.get(key);
        removeNode(node);
        add(node);
        return node.value;
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void put(int key, int value) {
        if(keyNode.containsKey(key)) {
            removeNode(keyNode.get(key));
        }
        Node node = new Node(key, value);
        add(node);
        keyNode.put(key, node);
        if(keyNode.size() > capacity) {
            Node nodeToBeDeleted = head.next;
            removeNode(nodeToBeDeleted);
            keyNode.remove(nodeToBeDeleted.key);
        }
    }

    private void add(Node node) {
        Node prevTail = tail.prev;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;
        prevTail.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */