class Solution {
    public int maxProduct(int[] nums) {
        int prod = nums[0];
        int maxi = 1;
        int mini = 1;

        for (int num : nums)
        {
            int temp = maxi * num;

            maxi = Math.max(num, Math.max(num * maxi, num * mini));
            mini = Math.min(num, Math.min(num * mini, temp));

            prod = Math.max(maxi, prod);
            
        }

        return prod;
    }
}