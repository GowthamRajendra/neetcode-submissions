class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int minNum = nums[0];

        while (l <= r)
        {
            if (nums[l] < nums[r])
            {
                return Math.min(minNum, nums[l]);
            }

            int m = l + (r - l) / 2;

            minNum = Math.min(minNum, nums[m]);

            if (nums[l] <= nums[m])
            {
                l = m + 1;
            } 
            else if (nums[m] < nums[r])
            {
                r = m - 1; 
            }
        }

        return minNum;
    }
}
