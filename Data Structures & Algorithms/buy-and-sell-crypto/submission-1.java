class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;

        int maxP = 0;

        while(r < prices.length)
        {
            if (prices[r] > prices[l])
            {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            }
            else if (prices[r] < prices[l])
            {
                l = r;
            }

            r++;
        }

        return maxP;

    }
}
