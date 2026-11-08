class FreqStack {
    HashMap<Integer, Integer> freqs ;
    List<Integer> stack;

    public FreqStack() {
        freqs = new HashMap<>();
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        freqs.put(val, freqs.getOrDefault(val, 0) + 1);
    }
    
    public int pop() {
        int maxi = -1;
        for (int value : freqs.values())
        {
            maxi = Math.max(maxi, value);
        }

        int i = stack.size() - 1;
        while (freqs.get(stack.get(i)) != maxi) i--;

        int value = stack.remove(i);
        freqs.put(value, freqs.get(value) - 1);

        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */