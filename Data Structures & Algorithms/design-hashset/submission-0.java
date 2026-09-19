class MyHashSet {
    private List<Integer> myset;

    public MyHashSet() {
        myset = new ArrayList<>();
    }
    
    public void add(int key) {
        if (!myset.contains(key)) myset.add(key);
    }
    
    public void remove(int key) {
        System.out.println(key);
        if (myset.contains(key)) myset.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return myset.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */