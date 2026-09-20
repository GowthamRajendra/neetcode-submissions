class MyHashMap {
    private int[] mymap;

    public MyHashMap() {
        mymap = new int[1000001];
        Arrays.fill(mymap, -1);
    }
    
    public void put(int key, int value) {
        mymap[key] = value;
    }
    
    public int get(int key) {
        return mymap[key];
    }
    
    public void remove(int key) {
        mymap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */