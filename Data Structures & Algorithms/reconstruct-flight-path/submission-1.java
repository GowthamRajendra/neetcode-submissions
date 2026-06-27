class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjMap = new HashMap<>();
        List<String> itin = new ArrayList<>();

        for (List<String> t : tickets)
        {
            adjMap.computeIfAbsent(t.get(0), 
                x -> new PriorityQueue<>()).offer(t.get(1));
        }

        Stack<String> myStack = new Stack<>();

        myStack.push("JFK");

        while (!myStack.isEmpty())
        {
            String source = myStack.peek();
            PriorityQueue<String> minheap = adjMap.get(source);

            if (minheap == null || minheap.isEmpty())
            {
                itin.add(myStack.pop());
            }
            else 
            {
                String dest = minheap.poll();
                myStack.push(dest);
            } 
            
        }

        Collections.reverse(itin);

        return itin;
    }   
}
