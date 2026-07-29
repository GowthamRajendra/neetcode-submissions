class Solution {
    boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) return false;

        memo = new boolean[s1.length() + 1][s2.length() + 1];

        return dfs(0,0,s1,s2,s3);
    }

    private boolean dfs(int i1, int i2, String s1, String s2, String s3)
    {
        if ((i1 + i2) >= s3.length())
        {
            return i1 >= s1.length() && i2 >= s2.length();
        }

        if (memo[i1][i2]) return true;

        boolean in = false;

        if (i1 < s1.length() && s3.charAt(i1 + i2) == s1.charAt(i1))
        {
            in = dfs(i1+1, i2, s1, s2, s3);
        }
        
        if (!in && i2 < s2.length() && s3.charAt(i1 + i2) == s2.charAt(i2))
        {
            in = dfs(i1, i2+1, s1, s2, s3);
        }

        memo[i1][i2] = in;
        
        return in;
    }
}
