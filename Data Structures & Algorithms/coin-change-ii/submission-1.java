class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        int n = coins.length;

        int[][]dp = new int[n+1][amount+1];

        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = 1;
        }


        for(int i = n-1; i>=0; i--)
        {
            for (int j = 0; j <= amount; j++)
            {

                if (j >= coins[i])
                {
                    int combs = 0;

                    combs += dp[i+1][j];
                    combs += dp[i][j-coins[i]];

                    dp[i][j] = combs; 

                }
            }
        }

        return dp[0][amount];
    }
}
