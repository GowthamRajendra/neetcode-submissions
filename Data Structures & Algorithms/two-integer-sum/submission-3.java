class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int[] output = new int[2];

        for (int i = 0; i < nums.length; i++)
        {
            int comp = target - nums[i];

            if (numbers.containsKey(comp))
            {
                output[0] = numbers.get(comp);
                output[1] = i;

                return output;
            }

            numbers.put(nums[i], i);            
        }

        return output;
    }
}
