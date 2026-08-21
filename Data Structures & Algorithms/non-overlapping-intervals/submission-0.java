class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0],y[0]));
        
        int remove = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] >= end)
            {
                end = intervals[i][1];
            }
            else // if (intervals[i][0] < end)
            {
                remove++;
                end = Math.min(end, intervals[i][1]);
            }
        }

        return remove;
    }
}
