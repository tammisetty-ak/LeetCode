/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode reverseLinkedList(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }

    public void reorderList(ListNode head) {

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list2 = reverseLinkedList(slow);
        ListNode list1 = head;

        ListNode list3 = new ListNode(0);

        while(list2 != null) {
            if(list1 == list2) {
                return;
            }
            list3.next = list1;
            list1 = list1.next;
            list3 = list3.next;

            list3.next = list2;
            list2 = list2.next;
            list3 = list3.next;
        }
        
    }
}