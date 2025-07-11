class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head, tail;

    Map<Integer, Node> keyNodeMap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!keyNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyNodeMap.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(keyNodeMap.containsKey(key)) {
            removeNode(keyNodeMap.get(key));
        }
        Node node = new Node(key, value);
        keyNodeMap.put(key, node);
        addNode(node);
        if(keyNodeMap.size() > capacity) {
            Node nodeToBeDeleted = head.next;
            removeNode(nodeToBeDeleted);
            keyNodeMap.remove(nodeToBeDeleted.key);
        }
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNode(Node node) {
        Node temp = tail.prev;
        node.prev = temp;
        temp.next = node;
        tail.prev = node;
        node.next = tail;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */