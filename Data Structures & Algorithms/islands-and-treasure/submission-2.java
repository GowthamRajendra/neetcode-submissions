class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length;
        
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 0) 
                {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true; 
                }
            }
        }

        int dist = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty())
        {
            int s = queue.size();

            for (int i = 0; i < s; i++)
            {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                grid[row][col] = dist;  

                for (int[] dir : directions) 
                {
                    int r = dir[0] + row;
                    int c = dir[1] + col;

                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[r].length &&
                        grid[r][c] != -1 && visited[r][c] == false)
                    {
                        visited[r][c] = true;
                        queue.add(new int[]{r, c});
                    }
                }
            }

            dist++;
        }

    }
}
