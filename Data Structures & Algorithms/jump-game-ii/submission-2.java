class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);

        int jumps = 0;
        int l = 0;
        
        while (!queue.isEmpty())
        {
            int size = queue.size();
            jumps++;
            
            for (int i = 0; i < size; i++)
            {
                int curr = queue.poll();
                int r = curr + nums[curr];

                if (r >= nums.length - 1) return jumps;

                for (int j = l + 1; j <= r; j++)
                {
                    if (j < nums.length) queue.add(j);
                }

                l = Math.max(l, r);
            }
        }

        return jumps;
    }
}
