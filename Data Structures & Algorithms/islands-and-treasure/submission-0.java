class Solution {

    private int land = 2147483647;
    private int ROWS; 
    private int COLS;

    public void islandsAndTreasure(int[][] grid) {

        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == land)
                { 
                    grid[r][c] = bfs(r, c, grid);
                }
            }
        }
    }

    private int bfs(int row, int col, int[][] grid)
    {
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        
        queue.add(new int[] {row, col});

        int dist = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length) continue;

                if (grid[r][c] == -1) continue; 

                if (visited[r][c] == true) continue;

                if (grid[r][c] == 0) return dist;

                visited[r][c] = true;

                queue.add(new int[] {r, c - 1});
                queue.add(new int[] {r, c + 1});
                queue.add(new int[] {r - 1, c});
                queue.add(new int[] {r + 1, c});
            }

            dist++;
        }

        return land;
    }
    

}
