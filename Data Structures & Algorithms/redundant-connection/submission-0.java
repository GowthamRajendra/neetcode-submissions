class Solution {

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> cycle = new HashSet<>();
    int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        
        for (int i = 0; i < edges.length + 1; i++) 
        {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        dfs(1, -1);

        for (int i = edges.length - 1; i >= 0; i--)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            if ( cycle.contains(u) && cycle.contains(v) )
            {
                return new int[] {u, v};
            }
        }

        return new int[] {};
    }

    private boolean dfs(int node, int prev)
    {
        if (visited.contains(node)) 
        {
            cycleStart = node;
            return true;
        }

        visited.add(node);

        for (int n : adjList.get(node))
        {
            if (n != prev)
            {
               if (dfs(n, node) == true)
               {
                    if (cycleStart != -1) cycle.add(node);

                    if (node == cycleStart) cycleStart = -1;

                    return true;
               }
            }
        }

        return false;
    }
}
