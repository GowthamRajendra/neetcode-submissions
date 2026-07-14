class Solution {

    int[] memo;
    
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);

        int mini = dfs(amount, coins);

        if (mini == Integer.MAX_VALUE) return -1;

        return mini;
    }

    private int dfs(int amount, int[] coins)
    {
        if (amount == 0) return 0;
        if (memo[amount] != -1) return memo[amount];

        int mini = Integer.MAX_VALUE;

        for (int coin : coins)
        {
            if ((amount - coin) >= 0)
            {
                int curr = dfs(amount - coin, coins);

                if (curr != Integer.MAX_VALUE) 
                {
                    mini = Math.min(mini, 1 + curr);
                }
            }
        }

        memo[amount] = mini;

        return mini;
    }
}
