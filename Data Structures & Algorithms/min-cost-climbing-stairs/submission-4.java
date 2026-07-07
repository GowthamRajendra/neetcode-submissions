class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int first = 0;
        int second = 0;

        for (int i = 2; i<= n; i++)
        {
            int c1 = cost[i-2] + first;
            int c2 = cost[i-1] + second;

            first = second;
            second = Math.min(c1, c2);
        }

        return second;
    }
}
