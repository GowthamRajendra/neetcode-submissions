class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < stones.length; i++)
        {
            maxheap.add(stones[i]);
        }

        while(maxheap.size() > 1)
        {
            int x = maxheap.poll();
            int y = maxheap.poll();

            if (x == y) continue;
            
            maxheap.add(x - y);
        }

        if (maxheap.size() == 0) return 0;

        return maxheap.peek();
    }
}
