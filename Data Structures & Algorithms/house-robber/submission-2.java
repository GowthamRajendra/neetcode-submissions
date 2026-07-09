class Solution {
    public int rob(int[] nums) {
        int n =  nums.length;

        if (n == 1) return nums[0];

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++)
        {
            // rob the house thats 2 houses behind 
            // and rob current house
            int rob = first + nums[i];

            // previous house was robbed (so skip current)
            int skip = second;

            first = second;
            second = Math.max(rob, skip);
        }

        return second;
    }
}
