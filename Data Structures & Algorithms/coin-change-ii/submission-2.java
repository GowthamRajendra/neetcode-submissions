class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        prev[0] = 1;

        for(int i = coins.length-1; i>=0; i--)
        {
            int[] curr = new int[amount+1];
            curr[0] = 1;

            for (int j = 1; j <= amount; j++)
            {
                curr[j] = prev[j];
                if (j >= coins[i])
                {
                    curr[j] += curr[j - coins[i]]; 
                }
            }

            prev = curr;
        }

        return prev[amount];
    }
}
