class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums)
        {
            HashMap<Integer, Integer> tempDp = new HashMap<>();

            for (int sum : dp.keySet())
            {
                int numWays = dp.get(sum);

                tempDp.put(sum + num, numWays + tempDp.getOrDefault(sum + num, 0));
                tempDp.put(sum - num, numWays + tempDp.getOrDefault(sum - num, 0));
            }

            dp = tempDp;
        }

        return dp.getOrDefault(target, 0);
    }
}
