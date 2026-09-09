class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> numset = new HashSet<>();

        for (int num : nums)
        {
            numset.add(num);
        }

        for (int i = 0; i <= nums.length; i++)
        {
            if (!numset.contains(i)) return i;
        }

        return -1;
    }
}
