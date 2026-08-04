class Solution {
    int L1;
    int L2;
    int[][] memo;

    public int minDistance(String word1, String word2) {
        L1 = word1.length();
        L2 = word2.length();
        memo = new int[L1][L2];

        for (int i = 0; i < L1; i++) 
        {
            for (int j = 0; j < L2; j++)
            {
                memo[i][j] = -1;
            } 
        }

        return dfs(0, 0, word1, word2);
    }

    private int dfs(int i, int j, String w1, String w2)
    {
        if (i == L1) return L2 - j;

        if (j == L2) return L1 - i;

        if (memo[i][j] != -1) return memo[i][j];
        
        int dist = 0;

        if (w1.charAt(i) == w2.charAt(j))
        {
           dist = dfs(i + 1, j + 1, w1, w2);
        }
        else
        {
            int ins = dfs(i, j+1, w1,w2);
            int del = dfs(i+1, j, w1,w2);
            int rep = dfs(i+1, j+1, w1,w2);

            dist = 1 + Math.min(ins, Math.min(del, rep));
        }

        memo[i][j] = dist;

        return dist;
    }
}
