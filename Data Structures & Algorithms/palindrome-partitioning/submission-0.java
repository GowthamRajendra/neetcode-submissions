class Solution {

    List<List<String>> substrs = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());

        return substrs;
    }

    private void backtrack(int i, String s, ArrayList<String> substr)
    {
        if (i == s.length())
        {
            substrs.add(new ArrayList<>(substr));
            return;
        }

        for(int j = i; j < s.length(); j++)
        {
            String curr = s.substring(i,j+1);

            if (!isPalindrome(curr)) continue;
        
            substr.add(curr);
            backtrack(j+1, s, substr);
            substr.remove(substr.size() - 1);
        }
    }


    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r)
        {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
            {
                l++;
            }

            while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
            {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) 
            {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
