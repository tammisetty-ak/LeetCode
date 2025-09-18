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

    private ListNode reverseLinkedList(ListNode head, int k){

        ListNode curr = head, prev = null, next;


        while(k > 0 && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) { // 1 2 3 4 5
        ListNode curr = head; // h - 1 2 3 4 5
        int count = 0;

        while(count < k && curr != null){ // 0 1
            curr = curr.next;
            count++;
        }

        if(count == k){
            ListNode reversedHead = reverseLinkedList(head, k); // 2 1 3 4 5

            head.next = this.reverseKGroup(curr, k); // 3 4 5
            return reversedHead;
        }

        return head;
        
    }
}