class Solution {
    int[][] memo;
    int m;
    int n;

    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        memo = new int[n][m];

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++)
            {
                memo[i][j] = -1;
            } 
        }

        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String text1, String text2)
    {
        if (j == m) return 1;

        if (i == n) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = dfs(i+1, j, text1, text2);

        if (text1.charAt(i) == text2.charAt(j))
        {
            memo[i][j] += dfs(i + 1, j + 1, text1, text2);   
        }

        return memo[i][j];
    }
}
