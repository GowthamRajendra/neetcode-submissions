class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) return -1;

        int[] diff = new int[gas.length];

        for(int i = 0; i < gas.length; i++)
        {
            diff[i] = gas[i] - cost[i];
        }
        
        int tank = 0;
        int index = 0;

        for (int i = 0; i < diff.length - 1; i++)
        {
            tank += diff[i];

            if (tank < 0)
            {
                index = i + 1;
                tank = 0;
            }
        }

        return index;
    }
}
