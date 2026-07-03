class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        Arrays.fill(cache, -1);

        return dfs(0, n);
    }

    private int dfs(int i, int n)
    {
        if (i == n) return 1;

        if (i > n) return 0;

        if (cache[i] != -1) return cache[i];

        cache[i] = dfs(i + 1, n) + dfs(i + 2, n);

        return cache[i];
    }
}
