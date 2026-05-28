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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;

        while (curr != null)
        {
            ListNode end = curr;

            int i = 0;
            while (end != null && i < k)
            {
                end = end.next;
                i++;
            }

            if (end == null) break;

            ListNode nextGroup = end.next;

            ListNode next = end.next;
            ListNode rev = curr.next;

            while (rev != nextGroup)
            {
                ListNode temp = rev.next;
                rev.next = next;

                next = rev;
                rev = temp;
            }
            
            ListNode temp = curr.next;
            curr.next = end;
            curr = temp;
        }

        return dummy.next;
    }
}
