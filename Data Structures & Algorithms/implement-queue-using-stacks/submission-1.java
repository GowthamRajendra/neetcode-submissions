class MyQueue {
    Stack<Integer> mainS;
    Stack<Integer> tempS;

    public MyQueue() {
        mainS = new Stack<>();
        tempS = new Stack<>();
    }
    
    public void push(int x) {
        mainS.push(x);
    }
    
    public int pop() {
        while (mainS.size() > 1)
        {
            tempS.push(mainS.pop());
        }

        int popped = mainS.pop();

        while(!tempS.isEmpty())
        {
            mainS.push(tempS.pop());
        }

        return popped;
    }
    
    public int peek() {
        while (mainS.size() > 1)
        {
            tempS.push(mainS.pop());
        }

        int peeked = mainS.peek();

        while(!tempS.isEmpty())
        {
            mainS.push(tempS.pop());
        }

        return peeked;
    }
    
    public boolean empty() {
        return mainS.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */