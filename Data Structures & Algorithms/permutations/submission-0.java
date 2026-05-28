class Solution {

    private List<List<Integer>> perms = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<Integer>());

        return perms;
    }

    private void dfs(int[] nums, ArrayList<Integer> perm)
    {
        if (perm.size() == nums.length)
        {
            perms.add(new ArrayList<>(perm));
            return;
        }

        for (int num : nums) {
            if (perm.contains(num)) continue;

            perm.add(num);
            dfs(nums, perm);
            perm.remove(perm.size() - 1);
        }

    }
}
