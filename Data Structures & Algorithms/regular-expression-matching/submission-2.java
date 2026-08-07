class Solution {
    int slen;
    int plen;
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        slen = s.length();
        plen = p.length();
        memo = new Boolean[slen+1][plen+1];

        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p)
    {
        if (j >= plen) return i >= slen;
         
        if (memo[i][j] != null) return memo[i][j];

        boolean match = false;

        if (i<slen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'))
        {
            match = true;
        }

        if (j+1 < plen && p.charAt(j+1) == '*')
        {
            memo[i][j] = (match && dfs(i+1, j, s, p)) || dfs(i, j+2, s, p);
        }
        else  
        {
            memo[i][j] =  match && dfs(i+1,j+1, s, p) ;
        }

        return memo[i][j];
    }
}
