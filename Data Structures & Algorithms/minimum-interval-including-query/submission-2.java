class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0],y[0]));

        PriorityQueue<int[]> minheap = new PriorityQueue<>((x, y) -> Integer.compare(x[0],y[0]));

        // [value, idx]
        int[][] qs = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) 
        {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }

        Arrays.sort(qs, (x, y) -> Integer.compare(x[0], y[0]));

        int[] mins = new int[queries.length];
        Arrays.fill(mins, -1);

        int i = 0;
        for (int[] q : qs)
        {
            while(i < intervals.length && intervals[i][0] <= q[0])
            {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minheap.offer(new int[]{r - l + 1, r});
                i++;
            }
            
            while(!minheap.isEmpty() && minheap.peek()[1] < q[0])
            {   
                minheap.poll();
            }

            if (!minheap.isEmpty()) mins[q[1]] = minheap.peek()[0];
        }

        return mins;
    }
}
