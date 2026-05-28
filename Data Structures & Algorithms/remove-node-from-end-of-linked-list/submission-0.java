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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;

        ListNode lenPass = head;

        while (lenPass != null)
        {
            len++;

            lenPass = lenPass.next;
        }

        int pos = len - n;

        if (pos == 0) return head.next;

        int i = 0;

        ListNode prev = head;
        ListNode found = null;

        while ( prev != null && prev.next != null )
        {
            i++;

            if (i-1 == pos-1)
            {
                prev.next = prev.next.next;
            } 
            else {
                prev = prev.next;
            }
        }

        
        return head;
    }

   
}
