class Solution {

    private List<List<Integer>> sets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<Integer>());

        return sets;
    }

    private void dfs(int i, int[] nums, ArrayList<Integer> sub)
    {
        if (i == nums.length)
        {
            sets.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        dfs(i + 1, nums, sub);
        
        sub.remove(sub.size() - 1);
        dfs(i + 1, nums, sub);

    }
}
