class Solution {
    public int minSubArrayLen(int target, int[] nums) {
   
        int l = 0;
        int smallest = Integer.MAX_VALUE;
        int sum = 0;

        for (int r = 0; r < nums.length; r++)
        {
            sum += nums[r];         

            while (sum >= target)
            {
                smallest = Math.min(r-l+1,smallest);
                sum -= nums[l];
                l++;
            }
        }

        if (smallest != Integer.MAX_VALUE) return smallest;

        return 0;
    }
}