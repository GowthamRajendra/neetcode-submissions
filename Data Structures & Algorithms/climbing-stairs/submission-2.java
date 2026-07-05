class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 1;

        for (int i = n-2; i >=0; i--)
        {
            int temp = first + second;
            first = second;
            second = temp;
        }

        return second;
    }
}
