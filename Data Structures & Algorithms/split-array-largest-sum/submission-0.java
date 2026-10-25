class Solution {
    public int splitArray(int[] nums, int k) {
        int r = Arrays.stream(nums).sum();
        int l = Arrays.stream(nums).max().getAsInt();

        int minsum = r;

        while (l <= r)
        {
            int m = l + ((r - l) / 2);

            if (checkSubarrs(nums, m) <= k)
            {
                minsum = m;
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }

        return minsum; 
    }

    private int checkSubarrs(int[] nums, int m)
    {
        int subarrs = 1;
        int s = 0;

        for(int num : nums)
        {
            s += num;

            if (s > m)
            {
                subarrs++;

                s = num;
            }
        }

        return subarrs;
    }
}