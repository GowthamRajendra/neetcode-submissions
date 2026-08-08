class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen+1][plen+1];

        dp[slen][plen] = true;

        for (int i = slen; i >=0; i--)
        {
            for (int j = plen - 1; j >= 0; j--)
            {
                boolean match = false;

                if (i<slen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
                {
                    match = true;
                }

                if (j+1 < plen && p.charAt(j+1) == '*')
                {
                    dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
                }
                else 
                {
                   dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
