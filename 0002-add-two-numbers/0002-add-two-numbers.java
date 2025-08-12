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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(-1);
        ListNode head = l3;

        while(l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }
            else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            l3.next = newNode;
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }

        while(l1 != null) {
            int sum = carry + l1.val;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }
            else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            l3.next = newNode;
            l1 = l1.next;
            l3 = l3.next;
        }

        while(l2 != null) {
            int sum = carry + l2.val;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }
            else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            l3.next = newNode;
            l2 = l2.next;
            l3 = l3.next;
        }

        if(carry > 0) {
            l3.next = new ListNode(carry);
        }

        return head.next;
    }
}