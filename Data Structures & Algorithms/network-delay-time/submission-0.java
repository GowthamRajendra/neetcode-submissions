class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<int[]>> adjMap = new HashMap<>();
        
        // source -> { {target, weight} , ...}
        for (int[] t : times)
        {
            adjMap.computeIfAbsent(t[0], x -> new ArrayList<>()).add(new int[] {t[1], t[2]});
        }

        // {distance, node}
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minheap.offer(new int[] {0,k});

        HashSet<Integer> visited = new HashSet<>(); 

        int currDist = 0;

        while (!minheap.isEmpty())
        {
            int[] curr = minheap.poll();
            int dist = curr[0];
            int node = curr[1];

            if (visited.contains(node)) continue;

            visited.add(node);

            currDist = dist;

            if (!adjMap.containsKey(node)) continue;

            for (int[] target : adjMap.get(node))
            {
                if (visited.contains(target[0])) continue;

                minheap.offer(new int[] {dist + target[1] ,target[0]});
            }
        }

        if (visited.size() == n) return currDist;

        return -1;
    }
}
