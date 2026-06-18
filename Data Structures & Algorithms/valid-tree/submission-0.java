class Solution {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (n-1 != edges.length ) return false;

        for (int i = 0; i < n; i++) 
        {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        if (dfs(0, -1) == false) return false;

        return visited.size() == n;
    }

    private boolean dfs(int node, int prev)
    {
        if (visited.contains(node)) return false;
        
        visited.add(node);

        for (int n : adjList.get(node))
        {
            if (n != prev)
            {
               if (dfs(n, node) == false) return false;
            }
        }

        return true;
    }
}
