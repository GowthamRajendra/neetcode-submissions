class Solution {

    int[][] memo;

    public int change(int amount, int[] coins) {
        memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo)
        {
            Arrays.fill(row, -1);
        }

        Arrays.sort(coins);

        return dfs(0, amount, coins);
    }


    private int dfs(int i, int amount, int[] coins)
    {
        if (i >= coins.length) return 0;

        if (amount == 0) return 1;

        if (memo[i][amount] != -1) return memo[i][amount];

        int combs = 0;

        if (amount >= coins[i])
        {
            combs += dfs(i+1, amount, coins);
            combs += dfs(i, amount - coins[i], coins); 
        }

        memo[i][amount] = combs;

        return combs;
    }
}
