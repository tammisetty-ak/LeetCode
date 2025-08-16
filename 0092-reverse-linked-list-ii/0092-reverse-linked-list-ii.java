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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        // Step 0: Dummy node to handle left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // Step 1: Move pre to the node just before 'left'
        for (int i = 1; i < left; i++) {
            if (pre == null) return head; // left is beyond length
            pre = pre.next;
        }

        // Step 2: Reverse sublist from left to right
        ListNode revStart = pre.next;
        ListNode revEnd = revStart;
        for (int i = left; i < right; i++) {
            if (revEnd.next == null) break; // right beyond length
            revEnd = revEnd.next;
        }

        ListNode post = revEnd.next;
        revEnd.next = null; // cut sublist

        // Reverse sublist
        ListNode newRevHead = reverse(revStart);

        // Reattach reversed sublist
        pre.next = newRevHead;
        revStart.next = post;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
