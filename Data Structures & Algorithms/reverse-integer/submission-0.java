class Solution {
    public int reverse(int x) {
        final int MIN = -2147483648; // -2^31
        final int MAX = 2147483647;  // 2^31 - 1

        int rev = 0;

        while (x != 0)
        {
            int last = x % 10;
            x = x / 10;

            // If bigger than 214748364 or rev = 214748364 but last dig >= 7
            if (rev > MAX / 10 || (rev == MAX / 10 && last > MAX % 10))
            {
                return 0;
            }

            // if smaller than -214748364 or rev= -214748364 but last dig < -8
            if (rev < MIN / 10 || (rev == MIN / 10 && last <= MIN % 10))
            {
                return 0;
            }

            rev = rev * 10 + last;
        }

        return rev;
    }
}
