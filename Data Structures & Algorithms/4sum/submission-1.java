class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            // skip dup
            if (i > 0 && nums[i] == nums[i-1]) continue;

            for (int j = i+1; j < nums.length; j++)
            {
                // skip dup
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                int l = j + 1;
                int r = nums.length - 1;

                while (l < r)
                {
                    long curr =  (long) nums[l] + nums[r] + nums[i] + nums[j]; 

                    if (curr > target)
                    {
                        r--;
                    } 
                    else if (curr < target)
                    {
                        l++;
                    }
                    else 
                    {
                        output.add(Arrays.asList(nums[l], nums[r], nums[i], nums[j]));
                        l++;
                        r--;

                        // skip dup
                        while (l < r && nums[l] == nums[l-1]) l++;
                        while (l < r && nums[r] == nums[r+1]) r--;
                    }
                }
            }
        }
        
        return output;
    }
}