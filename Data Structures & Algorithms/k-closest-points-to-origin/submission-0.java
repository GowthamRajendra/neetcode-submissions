class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // (sqrt((x1 - x2)^2 + (y1 - y2)^2))
        // x2, y2 is origin so 0
        PriorityQueue<int[]> minheap = new PriorityQueue<>((arr1, arr2) -> {
            double dist1 = Math.sqrt(arr1[0]*arr1[0] + arr1[1]*arr1[1]);
            double dist2 = Math.sqrt(arr2[0]*arr2[0] + arr2[1]*arr2[1]);
            return Double.compare(dist1, dist2);
        });

        for (int[] coord : points) {
            minheap.offer(coord);
        }

        int[][] closest = new int[k][2];

        for(int i = 0; i < k; i++)
        {
            closest[i] = minheap.poll();
        }

        return closest;
    }
}
