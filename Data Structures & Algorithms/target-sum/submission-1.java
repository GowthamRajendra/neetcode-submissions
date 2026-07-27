class Solution {
    HashMap<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();

        return dfs(0, nums, target, 0);
    }

    private int dfs(int i, int[] nums, int target, int total)
    {
        if (i >= nums.length) 
        {
            if (total == target) return 1;

            return 0;
        }
    
        String key = i + "," + total;

        if (memo.containsKey(key)) return memo.get(key);

        int curr = dfs(i+1, nums, target, total + nums[i]) + dfs(i+1, nums, target, total - nums[i]);

        memo.put(key, curr);

        return curr;
    }
}
