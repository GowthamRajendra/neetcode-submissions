class Solution {
    public int[] countBits(int n) {
        
        int[] count = new int[n+1];
        int offset = 1;
        
        for (int i = 1; i <= n; i++)
        {
            if (i == offset * 2) offset *= 2;

            count[i] = 1 + count[i - offset];
        }

        return count;
    }
}
