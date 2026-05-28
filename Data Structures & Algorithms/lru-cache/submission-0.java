class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val)
    {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node start;
    private Node end;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.start = new Node(0,0);
        this.end = new Node(0,0);

        this.start.next = end;
        this.end.prev = start;  
    }

    private void remove(Node node)
    {
        Node tempPrev = node.prev;
        Node tempNext = node.next;

        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
    }

    private void insert(Node node)
    {
        Node currPrev = this.end.prev;
        currPrev.next = node;
        node.prev = currPrev;
        node.next = this.end;
        this.end.prev = node;
    }

    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node curr = cache.get(key);
        
        remove(curr);
        insert(curr);

        return curr.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > this.capacity)
        {
            Node leftMost = this.start.next;
            remove(leftMost); 
            cache.remove(leftMost.key);
        }
    }
}
