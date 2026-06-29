class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length;

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[rows][cols];

        minheap.offer(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while(!minheap.isEmpty())
        {
            int[] curr = minheap.poll();
            int elev = curr[0];
            int row = curr[1];
            int col = curr[2];

            if ((row == rows - 1) && (col == cols - 1)) return elev;

            for (int[] dir : directions) 
            {
                int r = dir[0] + row;
                int c = dir[1] + col;

                if (r >= 0 && c >= 0 && r < rows && c < cols && visited[r][c] == false)
                {
                    visited[r][c] = true;
                    minheap.offer(new int[] {Math.max(elev, grid[r][c]), r, c});
                }
            }
        }

        return rows * cols;
    }
}
