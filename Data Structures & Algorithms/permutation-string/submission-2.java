class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> freqs = new HashMap<>(); 

        for (int i = 0; i < s1.length(); i++)
        {
            freqs.put(s1.charAt(i), freqs.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = s1.length() - 1;

        while (r < s2.length())
        {
            HashMap<Character, Integer> freqs2 = new HashMap<>(); 
            
            for (int i = l; i < r + 1; i++)
            {
                freqs2.put(s2.charAt(i), freqs2.getOrDefault(s2.charAt(i), 0) + 1);
            }

            if (freqs.equals(freqs2))
            {
                return true;
            }

            l++;
            r++;

        }

        return false;
    }
}
