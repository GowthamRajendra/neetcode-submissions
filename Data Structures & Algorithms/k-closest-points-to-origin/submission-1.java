class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // dont need sqrt since it doesnt make a diff when comparing
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((arr1, arr2) -> {
            int dist1 = arr1[0]*arr1[0] + arr1[1]*arr1[1];
            int dist2 = arr2[0]*arr2[0] + arr2[1]*arr2[1];
            return Integer.compare(dist2, dist1);
        }); 

        for (int[] coord : points)
        {
            maxheap.offer(coord);

            if (maxheap.size() > k)
            {
                maxheap.poll();
            }
        } 

        int[][] closest = new int[k][2];

        for(int i = 0; i < k; i++)
        {
            closest[i] = maxheap.poll();
        }

        return closest;
    }
}
