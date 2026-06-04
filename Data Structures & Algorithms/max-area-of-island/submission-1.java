class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == 1)
                { 
                    int area = bfs(r, c, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int bfs(int row, int col, int[][] grid)
    {
        LinkedList<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {row, col});

        int area = 0;

        while (!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length) continue;

            if (grid[r][c] == 0) continue; 

            grid[r][c] = 0;

            area++;

            queue.add(new int[] {r, c - 1});
            queue.add(new int[] {r, c + 1});
            queue.add(new int[] {r - 1, c});
            queue.add(new int[] {r + 1, c});
            
        }

        return area;
    }
}
