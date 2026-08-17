class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIdx = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            lastIdx.put(s.charAt(i), i);
        }

        ArrayList<Integer> output = new ArrayList<>();
        int size = 0;
        int last = 0;

        for (int i = 0; i < s.length(); i++)
        {
            size += 1;

            last = Math.max(lastIdx.get(s.charAt(i)), last);

            if (i == last)
            {
                output.add(size);
                size = 0;
            }
        }

        return output;
    }
}
