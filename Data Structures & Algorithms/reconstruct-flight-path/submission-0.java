class Solution {
    // auto sort with minheap
    HashMap<String, PriorityQueue<String>> adjMap = new HashMap<>();
    List<String> itin = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets)
        {
            adjMap.computeIfAbsent(t.get(0), 
                x -> new PriorityQueue<>()).offer(t.get(1));
        }

        dfs("JFK");

        Collections.reverse(itin);

        return itin;
    }

    private void dfs(String source)
    {
        PriorityQueue<String> minheap = adjMap.get(source);

        while(minheap != null && !minheap.isEmpty())
        {
            String dest = minheap.poll();
            dfs(dest);
        }

        itin.add(source);
    }
}
