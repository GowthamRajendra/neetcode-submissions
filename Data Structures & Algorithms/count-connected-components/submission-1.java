class Solution {

    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        int numComp = 0;

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
            bfs(i);
            numComp++;
        }

        return numComp;
    }

    private void bfs(int node)
    {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(node);

        visited.add(node);

        while (!queue.isEmpty())
        {
            int curr = queue.poll();

            for (int n : adjList.get(curr))
            {
                if (visited.contains(n)) continue;

                visited.add(n);

                queue.add(n);
            }
        }
    }
}
