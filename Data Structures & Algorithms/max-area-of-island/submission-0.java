class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == 1)
                { 
                    int area = dfs(r, c, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

     private int dfs(int r, int c, int[][] grid)
    {
        // if out of bounds
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length) return 0;
        
        if (grid[r][c] == 0) return 0;

        grid[r][c] = 0;

        int area = 1;

        area += dfs(r, c - 1, grid);
        area += dfs(r, c + 1, grid);
        area += dfs(r - 1, c, grid);
        area += dfs(r + 1, c, grid);

        return area;
    }
}
