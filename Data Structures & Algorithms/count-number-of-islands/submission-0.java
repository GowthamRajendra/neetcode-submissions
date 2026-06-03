class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == '1')
                { 
                    dfs(r, c, grid) ;
                    count++;
                }
            }
        }

        return count;
    }


    private void dfs(int r, int c, char[][] grid)
    {
        // if out of bounds
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length) return;
        
        if (grid[r][c] == '0') return;

        grid[r][c] = '0';

        dfs(r, c - 1, grid);
        dfs(r, c + 1, grid);
        dfs(r - 1, c, grid);
        dfs(r + 1, c, grid);
    }
}
