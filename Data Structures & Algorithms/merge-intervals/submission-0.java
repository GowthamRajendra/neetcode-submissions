class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0],y[0]));

        ArrayList<int[]> ins = new ArrayList<>();
        ins.add(intervals[0]);

        for(int[] interval : intervals)
        {  
            int[] prev = ins.get(ins.size()-1);

            if (interval[0] <= prev[1])
            {
                ins.get(ins.size()-1)[1] = Math.max(prev[1], interval[1]);
            } 
            else {
                ins.add(interval);
            }
        }

        return ins.toArray(new int[ins.size()][2]);
    }
}
