class Solution {
    
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    int numComp = 0;

    public int countComponents(int n, int[][] edges) {

        for (int i = 0; i < n; i++) 
        {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++)
        {
            if (visited.contains(i)) continue;
            dfs(i);
            numComp++;
        }

        return numComp;
    }

    private void dfs(int node)
    {
        if (visited.contains(node)) return;

        visited.add(node);

        for (int curr : adjList.get(node))
        {
            dfs(curr);
        }
    }

}
