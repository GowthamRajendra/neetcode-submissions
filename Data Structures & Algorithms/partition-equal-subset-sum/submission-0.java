class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
        {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length - 1; i >= 0; i--)
        {
            HashSet<Integer> temp = new HashSet<>();

            for (int val : dp)
            {
                if (val + nums[i] == target) return true;

                temp.add(val);
                temp.add(val + nums[i]);
            }

            dp = temp;
        }


        return false;
    }
}
