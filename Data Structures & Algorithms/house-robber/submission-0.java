class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(0, nums);
    }

    private int dfs(int i, int[] nums)
    {
        if (i >= nums.length) return 0;

        if (memo[i] != -1) return memo[i];
        
        int skip = dfs(i+1, nums);
        int rob = nums[i] + dfs(i+2, memo);

        memo[i] = Math.max(skip, rob);

        return memo[i];
    }
}
