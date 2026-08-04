class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++)
        {
            dp[n - i][m] = i;
        }

        for (int j = 0; j < m+1; j++)
        {
            dp[n][m-j] = j;
        }

        for (int i = n-1; i >= 0; i--)
        {
            for (int j = m-1; j >= 0; j--)
            {
                int dist = 0;

                if (word1.charAt(i) == word2.charAt(j))
                {
                    dist = dp[i + 1][j + 1];
                }
                else
                {
                    int ins = dp[i][j+1];
                    int del = dp[i+1][j];
                    int rep = dp[i+1][j+1];

                    dist = 1 + Math.min(ins, Math.min(del, rep));
                }

                dp[i][j] = dist;
            }
        }

        return dp[0][0];
        
    }
}
