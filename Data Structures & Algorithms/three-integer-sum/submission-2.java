class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            // rest are positive, cant become 0
            if (nums[i] > 0) break;
            // skip dup
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r)
            {
                int curr = nums[l] + nums[r] + nums[i]; 

                if (curr > 0)
                {
                    r--;
                } 
                else if (curr < 0)
                {
                    l++;
                }
                else 
                {
                    output.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    l++;
                    r--;

                    // skip dup
                    while (l < r && nums[l] == nums[l-1]) l++;
                }
            }
        }
        
        return output;
    }
}
