class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        int k = Integer.MAX_VALUE;

        while (l <= r)
        {
            int m = (l + r) / 2;
            
            int currk = 0;

            for (int i = 0; i < piles.length; i++)
            {
                currk += Math.ceil((double)piles[i]/m);
            }

            if (currk <= h)
            {
                k = m;
                r = m - 1;
            } 
            else {
                l = m + 1;
            }
        }    

        return k;    
    }
}
