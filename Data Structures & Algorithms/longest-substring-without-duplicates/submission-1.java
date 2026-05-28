class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seq = new HashSet<>();

        int l = 0;
        int r = 0;
        int output = 0;

        while(r < s.length())
        {
            while (seq.contains(s.charAt(r)))
            {
                seq.remove(s.charAt(l));
                l++;
            }   
            

            seq.add(s.charAt(r));
            output = Math.max(output, r - l + 1);

            r++;
        } 
        
        return output;
    }

   
}
