class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length;
        
        LinkedList<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 1)
                {
                    fresh++;
                }

                if (grid[i][j] == 2) 
                {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int mins = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(fresh > 0 && !queue.isEmpty())
        {
            int s = queue.size();

            for (int i = 0; i < s; i++)
            {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) 
                {
                    int r = dir[0] + row;
                    int c = dir[1] + col;

                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[r].length &&
                        grid[r][c] == 1)
                    {
                        queue.add(new int[]{r, c});
                        grid[r][c] = 2;
                        fresh--;
                    }

                }
            }
            
            mins++;
        }

        if (fresh == 0) return mins;

        return -1;
    }
}
