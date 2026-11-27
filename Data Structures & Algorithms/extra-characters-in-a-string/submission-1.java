class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> dictSet = new HashSet<>(Arrays.asList(dictionary));
    
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 0;

        for(int i = s.length() - 1; i >= 0; i--)
        {
            dp[i] = 1 + dp[i+1];

            for (int j = i; j < s.length(); j++)
            {
                if (dictSet.contains(s.substring(i,j+1)))
                {
                    dp[i] = Math.min(dp[i], dp[j+1]);
                }
            }
        }

        return dp[0];
    }
}