class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();

        for(int[] pr : prerequisites)
        {
            indegrees[pr[1]] += 1;
            adjMap.computeIfAbsent(pr[0], k -> new ArrayList<>()).add(pr[1]);
        }
        
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
        {
            if (indegrees[i] == 0) queue.add(i);
        }

        int taken = 0;

        while(!queue.isEmpty())
        {
            int curr = queue.poll();

            taken++;

            if (!adjMap.containsKey(curr)) continue;

            for (int course : adjMap.get(curr))
            {
                indegrees[course] -= 1;

                if (indegrees[course] == 0) queue.add(course);
            }
        }

        return taken == numCourses;

    }
}
