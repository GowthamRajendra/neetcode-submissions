class MedianFinder {

    private PriorityQueue<Integer> bigger; 
    private PriorityQueue<Integer> smaller;

    public MedianFinder() {
        bigger = new PriorityQueue<>();  
        smaller = new PriorityQueue<>(Comparator.reverseOrder()); 
    }
    
    public void addNum(int num) { 
        smaller.add(num);
        
        if (!bigger.isEmpty())
        {
            if (smaller.peek() > bigger.peek())
            {
                bigger.add(smaller.poll());
            } 
        }

        if (bigger.size() - smaller.size() > 1)
        {
            smaller.add(bigger.poll());
        } 

        if (smaller.size() - bigger.size() > 1)
        {
            bigger.add(smaller.poll());
        }
    }
    
    public double findMedian() {
        
        if ((bigger.size() + smaller.size()) % 2 == 0)
        {
            return (bigger.peek() + smaller.peek()) / 2.0;
        } else {
            if (bigger.size() > smaller.size())
            {
                return bigger.peek();
            } else {
                return smaller.peek();
            }
        }
    }
}
