class FreqStack {
    private Map<Integer, Integer> freqs;
    private Map<Integer, Stack<Integer>> stacks;
    private int maxFreq;
        
    public FreqStack() {
        freqs = new HashMap<>();
        stacks = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqs.getOrDefault(val, 0) + 1;
        freqs.put(val, freq);

        if (freq > maxFreq)
        {
            maxFreq = freq;
            stacks.put(freq, new Stack<>());
        }

        stacks.get(freq).push(val);
    }
    
    public int pop() {
        int val = stacks.get(maxFreq).pop();

        freqs.put(val, freqs.get(val) - 1);

        if (stacks.get(maxFreq).isEmpty()) maxFreq--;

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */