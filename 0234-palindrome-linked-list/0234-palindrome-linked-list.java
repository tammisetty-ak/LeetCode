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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while(slow != null) {
            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }

        ListNode right = prev;
        ListNode left = head;
        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}