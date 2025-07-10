class MyCircularDeque {

    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    ListNode head, tail;
    int capacity, size;

    public MyCircularDeque(int k) {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        capacity = k;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if(size >= capacity) {
            return false;
        }
        ListNode node = new ListNode(value);
        size++;
        ListNode temp = head.next;

        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size >= capacity) {
            return false;
        }

        ListNode node = new ListNode(value);
        size++;
        ListNode temp = tail.prev;

        node.prev = temp;
        temp.next = node;
        node.next = tail;
        tail.prev = node;
        
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) {
            return false;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next.prev = head;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) {
            return false;
        }

        ListNode temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size > 0) {
            return head.next.val;
        }
        return -1;
    }
    
    public int getRear() {
        if(size > 0) {
            return tail.prev.val;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

 /*

k - 3


_ _ _

_ _ 1

_ 1 2

3 1 2

3 1 2

2

3 1 2

3 1 _

4 3 1 
4



 */