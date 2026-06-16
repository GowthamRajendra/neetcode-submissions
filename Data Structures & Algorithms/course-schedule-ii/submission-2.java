class Solution {

    HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> path = new HashSet<>();
    ArrayList<Integer> ordering = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] pr : prerequisites)
        {
            adjMap.computeIfAbsent(pr[0], k -> new ArrayList<>()).add(pr[1]);
        }

        for (int i = 0; i < numCourses; i++)
        {
            if (dfs(i) == false) return new int[] {};
        }

        int[] output = new int[numCourses];

        System.out.println(ordering);

        for (int i = 0; i < numCourses; i++)
        {
            output[i] = ordering.get(i);
        }

        return output;
    }

    private boolean dfs(int course)
    {
        if (path.contains(course)) return false;

        if (visited.contains(course)) return true;

        path.add(course);

        if (adjMap.containsKey(course)) 
        {
            for (int c : adjMap.get(course))
            {
                if (dfs(c) == false)  return false;
            }
        }
        
        visited.add(course);
        path.remove(course);
        ordering.add(course);

        return true;
    }
}
