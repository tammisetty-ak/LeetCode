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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode half = slow;
        slow = head;

        ListNode prev = null;

        while(half != null) {
            ListNode temp = half.next;
            half.next = prev;
            prev = half;
            half = temp;
        }
        
        int max = Integer.MIN_VALUE;

        while(prev != null && slow != null) {
            max = Math.max(prev.val + slow.val, max);
            prev = prev.next;
            slow = slow.next;
        }

        return max;
    }
}