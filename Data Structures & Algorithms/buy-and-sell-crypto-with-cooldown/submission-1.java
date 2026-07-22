class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // 0 can buy 1 can sell 
        // n+2 since we are checking 2 ahead
        int[][] dp = new int[n+2][2];

        boolean[] canbuy = {true, false};

        for (int i = n - 1; i >=0; i--)
        {
            for (boolean buyable : canbuy)
            {
                if (buyable)
                {
                    int cd = dp[i+1][1];
                    int buy = dp[i+1][0] - prices[i];
                    dp[i][1] = Math.max(buy, cd);
                } 
                else {
                    int cd = dp[i+1][0];
                    // have to skip next day after sell
                    int sell = dp[i+2][1] + prices[i];
                    dp[i][0] = Math.max(sell, cd);
                }
            }
        }

        return dp[0][1];
    }
}
