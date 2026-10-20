class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int r = Arrays.stream(weights).sum();
        int l = Arrays.stream(weights).max().getAsInt();

        int mindays = r;

        while (l <= r)
        {
            int m = l + ((r - l) / 2);

            if (checkCap(weights, m) <= days)
            {
                mindays = Math.min(m, mindays);
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }

        return mindays; 
    }

    private int checkCap(int[] weights, int cap)
    {
        int ships = 1;
        int curr = 0;
        for (int w : weights)
        {
            if (curr + w > cap)
            {
                ships++;
                curr = 0;
            }

            curr += w;
        }

        return ships;
    }


}