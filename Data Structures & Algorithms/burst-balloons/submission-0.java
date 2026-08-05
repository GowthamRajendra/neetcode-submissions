class Solution {
    int n;
    int[][] memo;

    public int maxCoins(int[] nums) {
        n = nums.length;

        int[] balls = new int[n+2];
        balls[0] = 1;
        balls[n+1] = 1;

        for (int i = 1; i <= n; i++ )
        {
            balls[i] = nums[i-1];
        }

        memo = new int[n+2][n+2];

        for (int i = 0; i < n+2; i++) 
        {
            for (int j = 0; j < n+2; j++)
            {
                memo[i][j] = -1;
            } 
        }

        return dfs(1, n, balls);
    }

    private int dfs(int l, int r, int[] balls)
    {
        if (l > r) return 0;

        if (memo[l][r] != -1) return memo[l][r];
        
        memo[l][r] = 0;

        for (int i = l; i <= r; i++)
        {
            int coins = balls[l-1] * balls[i] * balls[r+1];
            int left = dfs(l, i-1, balls);
            int right = dfs(i+1, r, balls);

            memo[l][r] = Math.max(memo[l][r], coins + left + right);
        }

        return memo[l][r];
    }
}
