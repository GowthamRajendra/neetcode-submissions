class Solution {

    List<List<Integer>> sums = new ArrayList<>();
    int sum;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        dfs(0, nums, target, new ArrayList<>());

        return sums;
    }

    private void dfs(int i, int[] nums, int target, ArrayList<Integer> curr)
    {
        if(sum >= target ||  i >= nums.length)
        {
            if (sum == target) sums.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        sum += nums[i];
        dfs(i, nums, target, curr);

        sum -= nums[i];
        curr.remove(curr.size() - 1);
        dfs(i + 1, nums, target, curr);
    }
}
