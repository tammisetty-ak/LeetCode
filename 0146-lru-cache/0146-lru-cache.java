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

    private ListNode head;
    private ListNode tail;
    private int size;
    private int capacity;
    private Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        map = new HashMap();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            removeNode(oldNode);
        }

        ListNode newNode = new ListNode(key, value);

        map.put(key, newNode);
        addNode(newNode);
        if(map.size() > capacity) {
            ListNode nodeToBeDeleted = head.next;
            removeNode(nodeToBeDeleted);
            map.remove(nodeToBeDeleted.key);
        }
    }

    private void removeNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNode(ListNode node) {
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        node.prev = prevEnd;
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