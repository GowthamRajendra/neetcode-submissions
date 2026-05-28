class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> setNums = new HashSet<>();

        for(int num : nums)
        {
            setNums.add(num);
        }

        int longest = 0;

        for (int num : nums)
        {
            if(!setNums.contains(num-1))
            {
                int curr = 1;

                while( setNums.contains(num + curr) ) 
                {
                    curr += 1;
                } 

                longest = Math.max(longest, curr);
            }

        } 

        return longest;
    }
}
