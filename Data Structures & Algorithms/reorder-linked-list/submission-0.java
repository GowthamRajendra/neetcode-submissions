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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode next = slow.next = null;


        while (second != null)
        {
            ListNode temp = second.next; 
            second.next = next; 

            next = second;
            second = temp;
        }

        // next = head of reversed list

        ListNode first = head;


        while (next != null)
        {
            ListNode temp1 = first.next;
            ListNode temp2 = next.next;
            first.next = next;
            next.next = temp1;
            first = temp1;
            next = temp2;
        }
    }
}
