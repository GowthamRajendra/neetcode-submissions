class Solution {

    HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for (int[] pr : prerequisites)
        {
            adjMap.computeIfAbsent(pr[0], k -> new ArrayList<>()).add(pr[1]);
        }

        for (int i = 0; i < numCourses; i++)
        {
            if (dfs(i) == false) return false;
        }

        return true;
    }

    private boolean dfs(int course)
    {
        if (visited.contains(course)) return false;

        if (!adjMap.containsKey(course)) return true;

        visited.add(course);

        for (int c : adjMap.get(course))
        {
            if (dfs(c) == false)  return false;
        }
        
        visited.remove(course);
        adjMap.remove(course);

        return true;
    }
}
