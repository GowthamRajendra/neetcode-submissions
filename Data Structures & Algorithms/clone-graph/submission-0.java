/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;

        LinkedList<Node> queue = new LinkedList<>();

        HashMap<Node, Node> cloneMap = new HashMap<>();
        cloneMap.put(node, new Node(node.val));

        queue.add(node);

        while (!queue.isEmpty())
        {
            Node curr = queue.poll();

            for(Node neigh : curr.neighbors)
            {
                if(!cloneMap.containsKey(neigh)) 
                {
                    cloneMap.put(neigh, new Node(neigh.val));
                    queue.add(neigh);
                }

                cloneMap.get(curr).neighbors.add(cloneMap.get(neigh));
            }
        }

        return cloneMap.get(node);
    }
}