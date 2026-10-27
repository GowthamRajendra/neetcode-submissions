class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int sub = 0;
        int word = 0;

        while (word < t.length() && sub < s.length())
        {
            if (s.charAt(sub) == t.charAt(word))
            {
                sub++;
            }
            
            word++;
            
        }

        return sub == s.length();
    }
}