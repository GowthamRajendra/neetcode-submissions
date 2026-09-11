class Solution {
    public int getSum(int a, int b) {
        int sum1 = a ^ b;
        int sum2 = a & b;
        sum2 = sum2 << 1;

        while (sum2 != 0)
        {
            int c = sum1 & sum2;
            c = c << 1;
            sum1 = sum1 ^ sum2;
            sum2 = c;
        }

        return sum1;
    }
}
