class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);            
        }

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            counts.put(nums[i], counts.get(nums[i]) - 1);

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++)
            {
                counts.put(nums[j], counts.get(nums[j]) - 1);

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -nums[i] - nums[j];

                if (counts.getOrDefault(target, 0) > 0)
                {
                    output.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i + 1; j < nums.length; j++)
            {
                counts.put(nums[j], counts.get(nums[j]) + 1);            
            }
        }

        return output;
    }
}
