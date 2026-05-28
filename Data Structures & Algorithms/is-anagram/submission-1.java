class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
        {
            return false;
        }

        HashMap<Character, Integer> freqs = new HashMap<>();
        HashMap<Character, Integer> freqs2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            char letter = s.charAt(i);
            char letter2 = t.charAt(i);

            freqs.put(letter, freqs.getOrDefault(letter,0) + 1);
            freqs2.put(letter2, freqs2.getOrDefault(letter2,0) + 1);
            
        }

        return freqs.equals(freqs2);
    }
}
