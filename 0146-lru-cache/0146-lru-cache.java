class LRUCache {

    public class TreeNode {
        int key;
        int val;
        TreeNode prev;
        TreeNode next;

        public TreeNode() {
            prev = null;
            next = null;
        }

        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    int capacity;
    TreeNode head, tail;
    Map<Integer, TreeNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new TreeNode(-1, -1);
        tail = new TreeNode(-1, -1);
        map = new HashMap();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        TreeNode node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            deleteNode(map.get(key));
        }
        TreeNode node = new TreeNode(key, value);
        map.put(key, node);
        addNode(node);
        
        if(map.size() > capacity) {
            TreeNode nodeToDelete = head.next;
            deleteNode(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }
    private void addNode(TreeNode node) {
        TreeNode prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;
    }
    private void deleteNode(TreeNode node) {
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