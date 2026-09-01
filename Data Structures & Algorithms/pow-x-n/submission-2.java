class Solution {
    public double myPow(double x, int n) {
        if (n==0) return 1;
        if (x==0) return 0;

        double res = recurse(x, Math.abs( (int)n));
        
        if (n >= 0) return res;

        return 1/res;
    }

    private double recurse(double x, int n)
    {
        if (n==0) return 1;

        double res = 0.0;

        if (n % 2 == 0)
        {
            res += recurse(x, n/2);
            res *= res;
        }
        else 
        {
            res += recurse(x, n/2);
            res *= res * x; 
        }

        return res;
    }
}
