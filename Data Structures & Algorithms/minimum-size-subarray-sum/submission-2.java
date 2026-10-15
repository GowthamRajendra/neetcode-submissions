class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] prefix = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++)
        {
            prefix[i+1] = nums[i] + prefix[i];
        }

        int smallest = nums.length + 1;

        for (int i = 0; i < nums.length; i++)
        {
            int l = i;
            int r = nums.length;

            while (l < r)
            {
                int m = (l + r) /2;

                int sum = prefix[m+1] - prefix[i];

                if (sum >= target)
                {
                    r = m;
                }
                else 
                {
                    l = m + 1;
                }

            }
            
            if (l != nums.length) smallest = Math.min(smallest, l-i+1); 

        }

        return smallest % (nums.length + 1);
    }
}