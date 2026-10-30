class MyCircularQueue {
    private ArrayList<Integer> myq;
    private int size;

    public MyCircularQueue(int k) {
        myq = new ArrayList<>();
        size = k;
    }
    
    public boolean enQueue(int value) {
        if (myq.size() == size) return false;

        myq.add(value);

        return true;
    }
    
    public boolean deQueue() {
        if (myq.isEmpty()) return false;

        myq.remove(0);

        return true;
    }
    
    public int Front() {
        if (myq.isEmpty()) return -1;

        return myq.get(0);
    }
    
    public int Rear() {
        if (myq.isEmpty()) return -1;
        
        return myq.get(myq.size()-1);
    }
    
    public boolean isEmpty() {
        return myq.isEmpty();
    }
    
    public boolean isFull() {
        return myq.size() == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */