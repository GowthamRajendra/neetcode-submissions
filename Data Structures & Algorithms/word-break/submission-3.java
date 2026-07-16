class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        
        int maxLen = 0;
        for (String word : wordSet) {
            maxLen = Math.max(maxLen, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = i - 1; j >= Math.max(i - maxLen, 0); j--)
            {
                if (dp[j] && wordSet.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
