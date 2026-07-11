class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int longest = 0;
        int start = 0;
        int end = 0;

        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = i; j < n; j++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    if (((j - i) <= 2) || (dp[i+1][j-1]))
                    {
                        dp[i][j] = true;
                        
                        int len = j - i + 1;

                        if (len > longest)
                        {
                            longest = len;
                            start = i;
                            end = j + 1;
                        }
                    }
                }
            }
        }

        return s.substring(start, end);
    }
}
