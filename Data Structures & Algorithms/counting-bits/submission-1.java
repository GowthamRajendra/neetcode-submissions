class Solution {
    public int[] countBits(int n) {
        
        int[] count = new int[n+1];
        
        for (int i = 1; i <= n; i++)
        {
            count[i] = Integer.bitCount(i);
        }

        return count;
    }
}
