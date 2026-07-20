class Solution {
    int[][] memo;
    int m;
    int n;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        memo = new int[n][m];

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++)
            {
                memo[i][j] = -1;
            } 
        }

        return dfs(0, 0, text1, text2);
    }


    private int dfs(int i, int j, String text1, String text2)
    {
        if (i == n || j == m) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j))
        {
            memo[i][j] = 1 + dfs(i + 1, j + 1, text1, text2);
        }
        else 
        {
            memo[i][j] = Math.max(dfs(i+1, j, text1, text2), dfs(i,j+1, text1, text2));
        }

        return memo[i][j];
    }
}
