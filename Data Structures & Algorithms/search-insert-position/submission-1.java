class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int i = nums.length;

        while (l <= r)
        {
            int m = (int)Math.floor((r + l) / 2);

            if (target < nums[m])
            {
                i = m;
                r = m - 1;
            }
            else if (target > nums[m])
            {
                l = m + 1;
            } 

            if (nums[m] == target) {
                return m;
            }
        }

        return i;
    }
}