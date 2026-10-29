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
        
        ListNode dummy = new ListNode(0, head);

        ListNode leftNode = dummy;
        for (int i = 0; i < left-1; i++)
        {
            leftNode = leftNode.next;
        }

        ListNode subHead = leftNode.next;

        ListNode subTail = subHead;
        for (int i = 0; i < right-left; i++)
        {
            subTail = subTail.next;
        }

        ListNode rightNode = subTail.next;
        subTail.next = null;

        leftNode.next = reverseList(subHead);
        subHead.next = rightNode;

        return dummy.next;
    }

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