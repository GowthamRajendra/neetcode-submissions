class KthLargest {

    PriorityQueue<Integer> minheap;
    int K;

    public KthLargest(int k, int[] nums) {
        K = k;
        minheap = new PriorityQueue<>();;

        for (int i = 0; i < nums.length; i++)
        {
            minheap.add(nums[i]);
        }
    }

    public int add(int val) {
        minheap.add(val);

        while (minheap.size() > K)
        {
            minheap.poll();
        }

        return minheap.peek();
    }
}
