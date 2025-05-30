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
    public ListNode reverseList(ListNode head) {
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

/*

1 2 3 4 5 

null 1 2 3 4 5 
p - null, c - 1

temp = curr.next
t - 2 3 4 5
t - 3 4 5
t - 4 5
t - 5
t - null

curr.next = prev;
1 null
2 1 null
3 2 1 null
4 3 2 1 null
5 4 3 2 1 null


prev = curr
p - 1 null
p - 2 1 null
p - 3 2 1 null
p - 4 3 2 1 null
p - 5 4 3 2 1 null

curr = temp;
curr - 2 3 4 5
curr - 3 4 5
curr - 4 5
curr - 5
curr - null

*/