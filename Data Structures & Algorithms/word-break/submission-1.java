class Solution {

    HashMap<Integer, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);

        return dfs(0, s, wordDict);
    }

    private boolean dfs(int i, String s, List<String> wordDict)
    {
        if (memo.containsKey(i)) return memo.get(i);

        for (String word : wordDict)
        {
            if (i + word.length() <= s.length())
            { 
                if (word.equals(s.substring(i, i + word.length())))
                {
                    if (dfs(i + word.length(), s, wordDict))
                    {
                        memo.put(i, true);
                        return true;
                    }
                }
            }
        }

        memo.put(i, false);

        return false;
    }
}
