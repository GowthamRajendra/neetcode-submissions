class Solution {

    private List<List<Integer>> sets = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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

        while (i + 1 < nums.length && nums[i] == nums[i+1])
        {
            i++;
        }

        dfs(i + 1, nums, sub);

    }


}
