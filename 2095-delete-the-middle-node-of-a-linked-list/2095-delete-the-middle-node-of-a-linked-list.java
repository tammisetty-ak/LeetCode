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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)  {
            return null;
        }

// 2 1 3

// s - 2 f - 2

// s - 1 f - null

// f - null t - t.next

// 1 3 4 7 1 2 6

        ListNode fast = head; // 1
        ListNode slow = head; // 1
        ListNode temp = null; // n
        while(fast != null && fast.next != null) {  // 1 // 4 // 1 // 6
            temp = slow; // 1 // 3 // 4
            slow = slow.next; // 3 // 4 // 7
            fast = fast.next.next; // 4 // 1 // 6
        }

        temp.next = slow.next; // 7

        

        return head;
    }
}

/*
// 1 3 4 7 1 2 6 8

s - 1 f - 1

s - 3 f - 4

s - 4 f - 7

s - 7 f - 6

s - */
