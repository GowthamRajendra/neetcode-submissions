class Solution {

    List<List<Integer>> sums = new ArrayList<>();
    int sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>());

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
        dfs(i + 1, nums, target, curr);

        sum -= nums[i];
        curr.remove(curr.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i+1])
        {
            i++;
        }

        dfs(i + 1, nums, target, curr);
    }
}
