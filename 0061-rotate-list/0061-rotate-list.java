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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;

        while(tail.next != null) {
            len++;
            tail = tail.next;
        }

        tail.next = head;

        k = k % len;

        int stepsToNewTail = len - k;
        ListNode newTail = head;

        while(--stepsToNewTail > 0) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;


    }
}