class Solution {
    public int[] countBits(int n) {
        
        int[] count = new int[n+1];
        
        for (int i = 1; i <= n; i++)
        {
            int num = i;

            while (num != 0)
            {
                if (num % 2 == 1) count[i] += 1;
                num >>= 1;
            }
        }

        return count;
    }
}
