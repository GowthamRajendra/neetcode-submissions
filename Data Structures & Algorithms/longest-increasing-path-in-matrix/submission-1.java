class Solution {
    int dp[][];
    int ROWS;
    int COLS;

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        
        dp = new int[ROWS][COLS];

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                dp[i][j] = -1;
            }
        }

        int longest = 0;

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                longest = Math.max(longest, dfs(i, j, matrix));
            }
        }

        return longest;
    }


    private int dfs(int row, int col, int[][] matrix)
    {
        if (dp[row][col] != -1) return dp[row][col];

        int path = 1;

         for (int[] dir : directions) 
        {
            int r = dir[0] + row;
            int c = dir[1] + col;

            if (r >= 0 && c >= 0 && r < ROWS && c < COLS && 
                    matrix[r][c] > matrix[row][col])
            {
               path = Math.max(path, 1 + dfs(r, c, matrix));
            }
        }

        dp[row][col] = path;

        return path;
    }
}
