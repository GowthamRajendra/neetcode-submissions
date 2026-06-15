class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] ordering = new int[numCourses];
        int taken = 0;

        while(!queue.isEmpty())
        {
            int curr = queue.poll();

            ordering[numCourses - 1 - taken] = curr;
            taken++;

            if (!adjMap.containsKey(curr)) continue;

            for (int course : adjMap.get(curr))
            {
                indegrees[course] -= 1;

                if (indegrees[course] == 0) queue.add(course);
            }
        }

        if (taken == numCourses) return ordering;

        return new int[] {};
    }
}
