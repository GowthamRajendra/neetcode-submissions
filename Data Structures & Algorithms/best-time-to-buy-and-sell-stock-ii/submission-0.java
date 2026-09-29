class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = 0;
        int buy2 = 0;
        int sell1 = 0;
        int sell2 = 0;

        for (int i = prices.length-1; i >= 0; i--)
        {
            buy1 = Math.max(buy2, sell2 - prices[i]);
            sell1 = Math.max(sell2, buy2 + prices[i]);

            buy2 = buy1;
            sell2 = sell1;
        }

        return buy1;
    }
}