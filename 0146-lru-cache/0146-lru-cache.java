class LRUCache {

    public class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    ListNode head, tail;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        map = new HashMap();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            removeNode(map.get(key));
            map.remove(key);
        }

        ListNode node = new ListNode(key, value);
        map.put(key, node);
        addNode(node);
        if(map.size() > capacity) {
            ListNode nodeToBeDeleted = head.next;
            removeNode(nodeToBeDeleted);
            map.remove(nodeToBeDeleted.key);
        }
    }

    public void removeNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addNode(ListNode node) {
        ListNode prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */