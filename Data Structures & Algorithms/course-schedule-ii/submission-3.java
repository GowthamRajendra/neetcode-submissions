class Solution {

    HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
    ArrayList<Integer> ordering = new ArrayList<>();
    int[] indegrees;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegrees = new int[numCourses];

        for(int[] pr : prerequisites)
        {
            indegrees[pr[0]] += 1;
            adjMap.computeIfAbsent(pr[1], k -> new ArrayList<>()).add(pr[0]);
        }

        for (int i = 0; i < numCourses; i++)
        {
            if (indegrees[i] == 0) dfs(i);
        }

        if (ordering.size() != numCourses) return new int[] {};

        int[] output = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
        {
            output[i] = ordering.get(i);
        }

        return output;
    }

    private void dfs(int course)
    {
        ordering.add(course);
        indegrees[course] -= 1;

        if (!adjMap.containsKey(course)) return ;

        for (int c : adjMap.get(course))
        {
            indegrees[c] -= 1;
            if (indegrees[c] == 0) dfs(c);
        }
    }
}
