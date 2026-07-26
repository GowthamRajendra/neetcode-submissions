class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, target, 0);
    }

    private int dfs(int i, int[] nums, int target, int total)
    {
        if (i >= nums.length) 
        {
            if (total == target) return 1;

            return 0;
        }

        total +=  dfs(i+1, nums, target, total + nums[i]) + dfs(i+1, nums, target, total - nums[i]);

        return total;
    }
}
