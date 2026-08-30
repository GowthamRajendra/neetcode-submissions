class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = alg(n);

        while (slow != fast)
        {
            slow = alg(slow);
            fast = alg(alg(fast));
        }

        if (fast == 1) return true;

        return false;
    }

    private int alg(int n)
    {
        String s = Integer.toString(n);

        n = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int num = Integer.parseInt(String.valueOf(s.charAt(i)));
            n += num * num;
        }

        return n;
    }
}
