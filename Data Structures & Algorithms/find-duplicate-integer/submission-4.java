class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> dupes = new HashSet<>();

        for(int num : nums)
        {
            if (dupes.contains(num)) 
            {
                return num;
            } else {
                dupes.add(num);
            }
        }

        return -1;
    }
}
