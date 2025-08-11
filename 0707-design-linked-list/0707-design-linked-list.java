class MyLinkedList {

    LinkedList<Integer> linkedList;

    public MyLinkedList() {
        linkedList = new LinkedList<>();
    }

    public int get(int index) {
        // if(linkedList.isEmpty()) {
        //     index = 0;
        // }
        if (linkedList.size() <= index) {
            return -1;
        }
        return linkedList.get(index);
    }

    public void addAtHead(int val) {
        linkedList.addFirst(val);
        System.out.println(linkedList.toString());
    }

    public void addAtTail(int val) {
        linkedList.addLast(val);
        System.out.println(linkedList.toString());
    }

    public void addAtIndex(int index, int val) {
        if(index > linkedList.size()) {
            return;
        }
        else {
            if(index == linkedList.size()) {
                addAtTail(val);
            }
            else if(index <= 0) {
                addAtHead(val);
            }
            else {
                linkedList.add(index, val);
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || linkedList.size() <= index) {
            return;
        }
        linkedList.remove(index);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */