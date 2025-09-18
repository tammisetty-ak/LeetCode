/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ReverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int currCount = 0;
        ListNode currHead = curr;
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupTail = dummy;

        while(curr != null) {
            currCount++;
            if(currCount == k) {
                ListNode saveNext = curr.next;
                curr.next = null;
                ListNode reversed = reverseListNode(currHead);
                prevGroupTail.next = reversed;
                currHead.next = saveNext;
                prevGroupTail = currHead;
                currHead = saveNext;
                currCount = 0;
                curr = saveNext;
            }
            else {
                curr = curr.next;
            }
        }
        return dummy.next;

    }

    private ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}