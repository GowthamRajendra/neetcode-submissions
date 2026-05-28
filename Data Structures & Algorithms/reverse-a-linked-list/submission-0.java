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

/*
    [1] > [2] > [3]

*/

class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode next = null;

        while (head != null)
        {
            ListNode temp = head.next; // 2
            head.next = next; // null 

            next = head;
            head = temp;
        }

        return next;

    }
}
