class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] balls = new int[n + 2];
        balls[0] = 1;
        balls[n + 1] = 1;

        for (int i = 1; i <= n; i++) 
        {
            balls[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int l = n; l >= 1; l-- )
        {
            for (int r = l; r <= n; r++)
            {
                for (int i = l; i <= r; i++) 
                {
                    int coins = balls[l-1] * balls[i] * balls[r+1];
                    int left = dp[l][i-1];
                    int right = dp[i+1][r];

                    dp[l][r] = Math.max(dp[l][r], coins + left + right);
                }
            }
        }

        return dp[1][n];
    }
}
