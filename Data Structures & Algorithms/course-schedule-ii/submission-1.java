class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();

        for(int[] pr : prerequisites)
        {
            indegrees[pr[0]] += 1;
            adjMap.computeIfAbsent(pr[1], k -> new ArrayList<>()).add(pr[0]);
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

            ordering[taken] = curr;
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
