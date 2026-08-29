class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(!seen.contains(n))
        {
            seen.add(n);

            String s = Integer.toString(n);

            n = 0;
            for(int i = 0; i < s.length(); i++)
            {
                int num = Integer.parseInt(String.valueOf(s.charAt(i)));
                n += num * num;
            }

            if (n == 1) return true;
        }

        return false;
    }
}
