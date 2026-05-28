class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqs = new HashMap<>();

        for (int i = 0; i < tasks.length; i++)
        {
            freqs.put(tasks[i], freqs.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder()); 

        for (int freq : freqs.values()) 
        {
            maxheap.add(freq);
        } 

        Queue<int[]> taskQ = new LinkedList<>();

        int cycles = 0;

        while (!maxheap.isEmpty() || !taskQ.isEmpty())
        {
            cycles++;

            if (!maxheap.isEmpty())
            {
                int task = maxheap.poll();
                task--;

                if (task > 0) taskQ.add( new int[] {task, cycles + n});
            }

            if (!taskQ.isEmpty() && taskQ.peek()[1] == cycles)
            {
                maxheap.add(taskQ.poll()[0]);
            }
        }

        return cycles;
    }
}
