/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> nodeRef = new HashMap<>();

        Node first = head;

        while (first != null)
        {
            Node copy = new Node(first.val);

            nodeRef.put(first, copy);

            first = first.next;
        }

        Node second = head;

        while (second != null)
        {
            Node copy = nodeRef.get(second);

            copy.next = nodeRef.get(second.next);
            copy.random = nodeRef.get(second.random);
        
            second = second.next;
        }

        return nodeRef.get(head);

    }
}
