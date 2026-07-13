class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int n =  s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1; // len 0 string
        dp[1] = 1; // len 1 string

        for (int i = 2; i <= n; i++)
        {
            // s is 1 index behind dp
            if (s.charAt(i - 1) != '0') dp[i] = dp[i-1];

            int twoDig = Integer.parseInt(s.substring(i - 2, i));

            if ((twoDig > 9) && (twoDig < 27))
            {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}


