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
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            }
            else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if(l1 == null) {
            point.next = l2;
        }
        else {
            point.next = l1;
        }

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1;
        while(interval < lists.length) {
            for(int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists.length > 0 ? lists[0] : null;
    }

}