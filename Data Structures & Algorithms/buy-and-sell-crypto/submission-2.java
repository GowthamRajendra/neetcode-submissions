class Solution {
    public int maxProfit(int[] prices) {
        int lowest = 101;
        int maxProfit = 0;

        for (int price : prices)
        {
            int profit = price - lowest;
            maxProfit = Math.max(profit, maxProfit);
            lowest = Math.min(lowest, price);
        }

        return maxProfit;
    }
}
