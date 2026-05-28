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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (int i = 0; i < lists.length; i++)
        {
            minHeap.add(lists[i]);
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (!minHeap.isEmpty())
        {
            ListNode temp = minHeap.poll();

            if (temp.next != null) minHeap.add(temp.next);

            curr.next = temp;
            curr = curr.next;
        }

        return dummy.next;
    }
}
