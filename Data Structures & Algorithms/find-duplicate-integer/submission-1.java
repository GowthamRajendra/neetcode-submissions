class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        int n = nums.length;

        while (slow < n && fast < n)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (fast < n && slow == fast)
            {
                break; 
            }
        }

        int slow2 = 0;

        while(slow < n && slow2 < n)
        {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow == slow2)
            {
                break;
            }
        }

        return slow;
    }
}
