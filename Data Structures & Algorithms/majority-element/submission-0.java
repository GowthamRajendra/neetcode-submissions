class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqs = new HashMap<>();

        int[] majority = new int[2];

        for (int num : nums)
        {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

            if (freqs.get(num) > majority[1])
            {
                majority[0] = num;
                majority[1] = freqs.get(num);
            }
        }

        return majority[0];
    }
}