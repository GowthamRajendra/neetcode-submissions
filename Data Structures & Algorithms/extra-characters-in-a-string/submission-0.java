class Solution {
    HashSet<String> dictSet;
    int[] memo;


    public int minExtraChar(String s, String[] dictionary) {
        dictSet = new HashSet<>(Arrays.asList(dictionary));
        
        memo = new int[s.length()+1];
        Arrays.fill(memo, -1);
        memo[s.length()] = 0;

        return dfs(0, s);
    }


    private int dfs(int i, String s)
    {
        if (memo[i] != -1) return memo[i];

        int leftover = 1 + dfs(i+1, s); // skip

        for (int j = i; j < s.length(); j++)
        {
            if (dictSet.contains(s.substring(i,j+1)))
            {
                leftover = Math.min(leftover, dfs(j+1,s));
            }
        }

        memo[i] = leftover;

        return leftover;
    }
}