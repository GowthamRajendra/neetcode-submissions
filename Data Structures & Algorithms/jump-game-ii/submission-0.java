class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0; 
        int r = 0;

        while(r < nums.length - 1)
        {
            int jumpLen = 0;

            for (int i = l; i <= r; i++)
            {
                jumpLen = Math.max(jumpLen, nums[i] + i);
            }

            l = r + 1;
            r = jumpLen;

            jumps++;
        }

        return jumps;
    }
}
