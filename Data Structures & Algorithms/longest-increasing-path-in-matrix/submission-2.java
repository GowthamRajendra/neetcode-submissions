class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[][] indegrees = new int[ROWS][COLS];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                for (int[] dir : directions) 
                {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    
                    if (row >= 0 && row < ROWS && col >= 0 &&
                        col < COLS && matrix[row][col] < matrix[i][j]) 
                    {
                        indegrees[i][j] += 1;
                    }
                }
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (indegrees[i][j] == 0) queue.add(new int[] {i, j});
            }
        }

        int path = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) 
                {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row >= 0 && row < ROWS && col >= 0 &&
                        col < COLS && matrix[row][col] > matrix[r][c]) 
                    {

                        indegrees[row][col] -= 1;

                        if (indegrees[row][col] == 0) queue.add(new int[] {row, col});

                    }
                }
            }
            path++;
        }

        return path;

    }
}
