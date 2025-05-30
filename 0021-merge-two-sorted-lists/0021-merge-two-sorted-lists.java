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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3 = new ListNode(-1, null);
        ListNode node = new ListNode();
        ListNode head = l3;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                node = new ListNode(list1.val, null);
                list1 = list1.next; 
            }

            else {
                node = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            l3.next = node;
            l3 = l3.next;
        }

        while(list1 != null) {
            node = new ListNode(list1.val, null);
            l3.next = node;
            l3 = l3.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            node = new ListNode(list2.val, null);
            l3.next = node;
            l3 = l3.next;
            list2 = list2.next;
        }

        return head.next;

    }
}