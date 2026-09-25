class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1 = 0;
        int i2 = 0;

        String merged = "";

        while (i1 < word1.length() && i2 < word2.length())
        {
            merged += word1.charAt(i1);
            merged += word2.charAt(i2);
            i1++;
            i2++;
        }

        if (i1 == word1.length()) merged += word2.substring(i1);
        if (i2 == word2.length()) merged += word1.substring(i2);

        return merged;
    }
}