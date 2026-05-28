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
    538
    656/
    1194
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;

        ListNode sum = new ListNode();
        ListNode curr = sum;

        while (l1 != null || l2 != null || carry != 0)
        {
            int v1 = 0;
            int v2 = 0;

            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            } else {
                l1 = null;
            }
        
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }else {
                l2 = null;
            }

            int s = v1 + v2 + carry;

            carry = s / 10;
            s = s % 10;
    
            curr.next = new ListNode(s); 
            curr = curr.next;   
        }

        return sum.next;
    }
}
