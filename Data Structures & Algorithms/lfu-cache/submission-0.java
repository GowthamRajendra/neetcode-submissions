class Node {
    int value;
    int count;
    int timestamp;

    Node(int value, int count, int timestamp) 
    {
        this.value = value;
        this.count = count;
        this.timestamp = timestamp;
    }
}

class LFUCache {
    private HashMap<Integer, Node> cache;
    private int capacity;
    private int timestamp;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.timestamp = 0;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node curr = cache.get(key);
        curr.count++;
        timestamp++;
        curr.timestamp = timestamp;

        return curr.value;
    }
    
    public void put(int key, int value) {
        timestamp++;

        if (cache.containsKey(key))
        {
            Node curr = cache.get(key);
            curr.value = value;
            curr.count++;
            curr.timestamp = timestamp;
            return;
        }

        if (cache.size() < capacity)
        {
            cache.put(key, new Node(value, 1, timestamp));
            return;
        }

        int minCount = Integer.MAX_VALUE;
        int minTimestamp = Integer.MAX_VALUE;
        int minKey = -1;

        for (Map.Entry<Integer, Node> entry : cache.entrySet()) 
        {
            Node curr = entry.getValue();

            if (curr.count < minCount || (curr.count == minCount && curr.timestamp < minTimestamp)) {
                    minCount = curr.count;
                    minTimestamp = curr.timestamp;
                    minKey = entry.getKey();
                }
        }

        cache.remove(minKey);
        cache.put(key, new Node(value, 1, timestamp));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */