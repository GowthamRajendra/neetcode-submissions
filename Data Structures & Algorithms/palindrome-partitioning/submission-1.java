class Solution {

    List<List<String>> substrs = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, 0, s, new ArrayList<>());

        return substrs;
    }

    private void backtrack(int j, int i, String s, ArrayList<String> substr)
    {
        if (i == s.length())
        {
            if (j == s.length()) substrs.add(new ArrayList<>(substr));
            return;
        }

        String curr = s.substring(j,i+1);

        if (isPalindrome(curr))
        {
            substr.add(curr);
            backtrack(i+1, i+1, s, substr);
            substr.remove(substr.size() - 1);
        }

        backtrack(j, i+1, s, substr);
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
