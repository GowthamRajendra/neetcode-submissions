class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n-1 != edges.length ) return false;
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        LinkedList<int[]> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(new int[] {0, -1});

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int node = curr[0];
            int prev = curr[1];

            if (visited.contains(node)) return false;

            visited.add(node);

            for (int adj : adjList.get(node))
            {
                if (adj != prev)
                {
                    queue.add(new int[] {adj, node});
                }
            }
        }

        return visited.size() == n;
    }
}
