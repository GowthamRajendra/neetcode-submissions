class Solution {

    private HashMap<String, Integer> memo;

    public int maxProfit(int[] prices) {
        memo = new HashMap<>();

        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean buyable, int[] prices)
    {
        if (i >= prices.length) return 0;

        String key = i + "," + buyable;

        if (memo.containsKey(key)) return memo.get(key);

        int cd = dfs(i+1, buyable, prices);

        if (buyable)
        {
            int buy = dfs(i+1, false, prices) - prices[i];
            memo.put(key, Math.max(buy, cd));
        } 
        else {
            // have to skip next day after sell
            int sell = dfs(i+2, true, prices) + prices[i];
            memo.put(key, Math.max(sell, cd));
        }

        return memo.get(key);
    }
}
