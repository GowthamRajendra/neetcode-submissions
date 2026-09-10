class Solution {
    public int missingNumber(int[] nums) {
        int missing = 0;

        for (int i = 0; i < nums.length; i++)
        {
            missing = missing ^ i ^ nums[i];
        }

        return missing ^ nums.length;
    }
}
