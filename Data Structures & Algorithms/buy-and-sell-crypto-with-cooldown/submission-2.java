class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // 0 can buy 1 can sell 
        int[] back1 = new int[2]; // 1 behind
        int[] back2 = new int[2]; // 2 behind

        for (int i = n - 1; i >=0; i--)
        {
            int[] curr = new int[2];
            
            int cd1 = back1[0];
            int buy = back1[1] - prices[i];
            curr[0] = Math.max(buy, cd1);
    
            int cd2 = back1[1];
            // have to skip next day after sell
            int sell = back2[0] + prices[i];
            curr[1] = Math.max(sell, cd2);
    

            back2 = back1;
            back1 = curr;
        }

        return back1[0];
    }
}
