class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        HashMap<Integer, ArrayList<int[]>> adjMap = new HashMap<>();

        for (int[] f : flights)
        {
            adjMap.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[] {f[1], f[2]});
        }

        int stops = 0;

        // price, city, stops
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, src, stops});
        
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int cost = curr[0];
            int city = curr[1];
            int s = curr[2];

            if (s > k) break;

            if (!adjMap.containsKey(city)) continue;

            for (int[] neigh : adjMap.get(city))
            {   
                int to = neigh[0];
                int newCost = cost + neigh[1];

                if (newCost < prices[to])
                {
                    prices[to] = newCost;
                    queue.add(new int[] {newCost, to, s+1});
                }
            }
        }

        if (prices[dst] == Integer.MAX_VALUE) return -1;

        return prices[dst];
    }
}
