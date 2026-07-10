class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int skipFirst = helpRob(nums, 1, nums.length - 1);
        int robFirst = helpRob(nums, 0, nums.length - 2);

        return Math.max(skipFirst, robFirst);
    }

    private int helpRob(int[] nums, int start, int end)
    {
        int n = end - start + 1;
        
        if (n == 1) return nums[start];
        if (n == 2) return Math.max(nums[start], nums[end]);

        int[] dp = new int[n];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[1 + start]);

        for (int i = 2; i < n; i++)
        {
            // rob the house thats 2 houses behind 
            // and rob current house
            int rob = dp[i-2] + nums[i + start];

            // previous house was robbed (so skip current)
            int skip = dp[i-1];

            dp[i] = Math.max(rob, skip);
        }

        return dp[n - 1];
    }
}
