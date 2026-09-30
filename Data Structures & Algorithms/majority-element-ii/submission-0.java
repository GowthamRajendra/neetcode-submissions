class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        HashSet<Integer> elems = new HashSet<>();

        for (int num : nums)
        {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

            if (freqs.get(num) > nums.length/3) elems.add(num);
        }

        return new ArrayList<>(elems);
    }
}