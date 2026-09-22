class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];

        for (int num : nums)
        {
            bucket[num] += 1;
        }

        int j = 0;
        for (int i = 0; i < bucket.length; i++)
        {
            while (bucket[i] > 0)
            {
                nums[j] = i;
                j++;
                bucket[i] -= 1;
            }
        }
    }
}