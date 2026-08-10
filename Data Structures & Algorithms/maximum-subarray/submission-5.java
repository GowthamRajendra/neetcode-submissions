class Solution {
    public int maxSubArray(int[] nums) {
        return dfs(0, nums.length-1, nums);
    }

    private int dfs(int l, int r, int[] nums)
    {
        if (l > r) return Integer.MIN_VALUE;

        int m = (int)Math.floor((r + l) / 2);

        int left = 0;
        int sum = 0;
        for (int i = m-1; i >= l; i--)
        {
            sum += nums[i];
            left = Math.max(left, sum);
        }

        int right = 0;
        sum = 0;
        for (int i = m+1; i <= r; i++)
        {
            sum += nums[i];
            right = Math.max(right, sum);
        }

        int middle = right + left + nums[m];
        int maxLeft = dfs(l,m-1,nums);
        int maxRight = dfs(m+1,r,nums);

        return Math.max(middle, Math.max(maxLeft, maxRight));
    }
}
