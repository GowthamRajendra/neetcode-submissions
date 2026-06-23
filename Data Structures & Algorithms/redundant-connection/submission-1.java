class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indegrees = new int[n];

        for (int i = 0; i < n; i++) 
        {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            indegrees[edge[0]] += 1;
            indegrees[edge[1]] += 1;

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n; i++)
        {
            if (indegrees[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty())
        {
            int curr = queue.poll();
            indegrees[curr] -= 1;

            for (int adj : adjList.get(curr))
            {
                indegrees[adj] -= 1;

                if (indegrees[adj] == 1) queue.add(adj);
            }
        }
        
        for (int i = edges.length - 1; i >= 0; i--)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            if ( indegrees[u] > 0 && indegrees[v] > 0 )
            {
                return new int[] {u, v};
            }
        }

        return new int[] {};
    }
}
