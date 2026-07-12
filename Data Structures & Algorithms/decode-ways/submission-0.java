class Solution {
    int[] memo;
    
    public int numDecodings(String s) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        memo[s.length()] = 1;
        
        return dfs(0, s);
    }

    private int dfs(int i, String s)
    {
        if (memo[i] != -1) return memo[i];

        if (s.charAt(i) == '0') return 0;

        int count = dfs(i+1, s);

        if (i < s.length() - 1) // need to check 2 chars
        {
            if (Integer.parseInt(s.substring(i, i + 2)) < 27)
            {
                count += dfs(i+2, s);
            }
        }
        
        memo[i] = count;
        
        return count;
    }

}
