class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (numMap.containsKey(nums[i]) && (Math.abs(i) - numMap.get(nums[i])) <= k)
            {
                return true;
            }

            numMap.put(nums[i], i);
        }

        return false;
    }
}