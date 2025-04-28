class ListNode{
    int key;
    int val;

    ListNode prev;
    ListNode next;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    ListNode head, tail;
    int capacity;
    HashMap<Integer, ListNode> map;

    public void addNode(ListNode node){
        ListNode prevEnd = tail.prev;

        prevEnd.next = node;
        node.prev = prevEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void removeNode(ListNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        map = new HashMap<>();

        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);

            removeNode(node);

            addNode(node);
            return node.val;
        }
        return -1;

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode oldNode = map.get(key);

            removeNode(oldNode);
        }

        ListNode node = new ListNode(key, value);
        map.put(key, node);
        addNode(node);
        if(map.size() > capacity){
            ListNode nodeToBeDeleted = head.next;
            removeNode(nodeToBeDeleted);
            map.remove(nodeToBeDeleted.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */