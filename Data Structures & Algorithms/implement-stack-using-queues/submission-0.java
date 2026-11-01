class MyStack {
    private Queue<Integer> mainq;
    private Queue<Integer> tempq;

    public MyStack() {
        mainq = new LinkedList<>();
        tempq = new LinkedList<>();
    }
    
    public void push(int x) {
        tempq.add(x);

        while(!mainq.isEmpty())
        {
            tempq.add(mainq.poll());
        }

        mainq = tempq;
        tempq = new LinkedList<>();
    }
    
    public int pop() {
        return mainq.poll();
    }
    
    public int top() {
        return mainq.peek();
    }
    
    public boolean empty() {
        return mainq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */