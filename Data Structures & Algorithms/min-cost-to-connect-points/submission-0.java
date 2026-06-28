class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        HashSet<Integer> visited = new HashSet<>();
        
        int minCost = 0; 

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        minheap.offer(new int[]{0, 0});

        while(visited.size() < points.length)
        {
            int[] curr = minheap.poll();
            int cost = curr[0];
            int node = curr[1];

            if (visited.contains(node)) continue;
            visited.add(node);

            minCost += cost;
            int[] p1 = points[node];

            for (int i = 0; i < points.length; i++ )
            {
                if(visited.contains(i)) continue;

                int p2[] = points[i];

                int manhatten = Math.abs(p2[0] - p1[0]) + Math.abs(p2[1] - p1[1]);

                minheap.offer(new int[] {manhatten, i});
            }
        }

        return minCost;
    }
}
