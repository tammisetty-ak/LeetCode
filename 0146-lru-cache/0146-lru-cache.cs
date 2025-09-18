public class LRUCache {

    public class ListNode {
        public int key;
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private ListNode tail = new ListNode(-1, -1);
    private ListNode head = new ListNode(-1, -1);

    private int cap;

    private Dictionary<int, ListNode> map = new Dictionary<int, ListNode>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int Get(int key) {
        if(map.ContainsKey(key)) {
            ListNode node = map[key];
            RemoveNode(node);
            AddNode(node);
            return node.val;
        }
        return -1;
    }

    private void RemoveNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void Put(int key, int value) {
        if(map.ContainsKey(key)) {
            ListNode nodeToBeDeleted = map[key];
            RemoveNode(nodeToBeDeleted);
            map.Remove(key);
        }
        ListNode node = new ListNode(key, value);
        AddNode(node);
        map[key] = node;
        if(map.Count > cap) {
            ListNode lru = head.next;
            RemoveNode(lru);
            map.Remove(lru.key);
        }

    }

    private void AddNode(ListNode node) {
        // ListNode node = new ListNode(key, value);
        ListNode prevTail = tail.prev;
        node.prev = prevTail;
        prevTail.next = node;
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */