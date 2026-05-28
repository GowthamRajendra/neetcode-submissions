class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> output = new HashMap<>();
        
        for (String str : strs)
        {
            int[] freqs = new int[26];

            for (int i = 0; i < str.length(); i++)
            {
                freqs[(int)str.charAt(i) - 97] += 1;
            }
            
            String key = Arrays.toString(freqs);
            output.putIfAbsent(key, new ArrayList<>());
            output.get(key).add(str);
        }

        return new ArrayList<>(output.values());
    }
}
