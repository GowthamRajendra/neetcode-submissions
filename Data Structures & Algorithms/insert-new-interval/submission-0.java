class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> ins = new ArrayList<>();
        boolean inserted = false;

        for(int[] interval : intervals)
        {
            // already inesrted
            if (inserted)
            {
                ins.add(interval);
                continue;
            }

            // interval after new 
            if (newInterval[1] < interval[0])
            {
                ins.add(newInterval);
                ins.add(interval);
                inserted = true;
            }
            // interval before new  
            else if (interval[1] < newInterval[0])
            {
                ins.add(interval);
            }
            // overlap
            else 
            {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if (!inserted) ins.add(newInterval);
        
        return ins.toArray(new int[ins.size()][2]);
    }
}
