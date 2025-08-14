class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode main = head;
        ListNode temp = head.next;
        ListNode countNodes = head;
        int n = 0;
        while (countNodes != null) {
            countNodes = countNodes.next;
            n++;
        }
        n--;
        int index = 2;
        while (temp != null) {
            ListNode list = new ListNode(0);
            int nodeCount = 1;

            if (index % 2 == 0 && n >= index) {

                while (nodeCount <= index && temp != null) {
                    ListNode temp2 = temp;
                    temp = temp.next;
                    temp2.next = list;
                    list = temp2;
                    nodeCount++;
                    n--;
                }
                ListNode insert = list;
                while (list.next.next != null) {
                    list = list.next;
                }
                list.next = temp;
                main.next = insert;
                main = list;
            } else {
                if (n % 2 == 0 && n < index) {
                    while (nodeCount <= index && temp != null) {
                        ListNode temp2 = temp;
                        temp = temp.next;
                        temp2.next = list;
                        list = temp2;
                        nodeCount++;
                        n--;
                    }
                    ListNode insert = list;
                    while (list.next.next != null) {
                        list = list.next;
                    }
                    list.next = temp;
                    main.next = insert;
                    main = list;
                } else {
                    while (nodeCount <= index && temp != null) {
                        temp = temp.next;
                        main = main.next;
                        nodeCount++;
                        n--;
                    }
                }

            }
            index++;
        }
        return head;
    }
}