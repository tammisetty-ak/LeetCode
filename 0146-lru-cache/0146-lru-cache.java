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
    int capacity;
    Map<Integer, Node> keyNodeMap;

    public LRUCache(int capacity) {
        keyNodeMap = new HashMap();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyNodeMap.containsKey(key)) {
            return -1;
        }
        removeNode(keyNodeMap.get(key));
        addNode(keyNodeMap.get(key));
        return keyNodeMap.get(key).val;
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

    private void addNode(Node node) {
        Node temp = tail.prev;
        node.next = tail;
        node.prev = temp;
        temp.next = node;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */