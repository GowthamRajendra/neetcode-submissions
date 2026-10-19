class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        int sqrt = 0;

        while (l <= r)
        {
            int m = l + ((r - l) / 2);

            if (x < (long)m*m)
            {
                r = m - 1;
            }
            else if (x > (long)m*m)
            {
                l = m + 1;
                sqrt = m;
            } 
            else {
                return m;
            }
        }

        return sqrt;
    }
}