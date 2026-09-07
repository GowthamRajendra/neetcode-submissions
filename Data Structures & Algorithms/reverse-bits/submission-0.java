class Solution {
    public int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < 32; i++)
        {
            // shift to get to current spot (like this where curr is last bit)
            // n=00000000000000000000000000010101
            // n=0000000000000000000000000001010
            // n=000000000000000000000000000101
            // n=00000000000000000000000000010
            int bit = n >> i;
            // & with 1 gives the bit we're on (0&1=0 1&1=1)
            bit = bit & 1;
            // makes more sense to do like this 
            // int bit = (n >> i) & 1;

            // shift bit from least sig to most sig (shifts the bit left)
            // ex: the 1 at end became 1 at the start
            // n=00000000000000000000000000010101
            // n=10000000000000000000000000000000
            bit = bit << (31 - i);
            // | ensures only the 0s in the rev are changes to 1s
            // (0 | 1 = 1)  (0 | 0 = 0)
            rev = rev | bit;
            // makes more sense to do like this
            // rev =  rev | (bit << (31 - i));
        }

        return rev;
    }
}
