class Solution {
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int maxSub = 1;
        for (int i = 0 ; i < nums.length; i++)
        {
            maxSub = Math.max(maxSub, dfs(i, nums));
        }

        return maxSub;
    }

    private int dfs(int i, int[] nums)
    {
        if (memo[i] != -1) return memo[i];

        int maxi = 1;
        for (int j = i+1; j < nums.length; j++)
        {
            if (nums[j] > nums[i])
            {
                maxi = Math.max(maxi, 1 + dfs(j, nums));
            }
        }

        memo[i] = maxi;

        return memo[i];
    }
}
