class Solution {
    private int ROWS;
    private int COLS;

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> flow = new ArrayList<>();

        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacCanFlow = new boolean[ROWS][COLS];
        boolean[][] atlCanFlow = new boolean[ROWS][COLS];

        for(int i = 0 ; i < ROWS; i++)
        {
            dfs(i, 0, heights, pacCanFlow);
            dfs(i, COLS-1, heights, atlCanFlow);
        }

        for(int i = 0 ; i < COLS; i++)
        {
            dfs(0, i, heights, pacCanFlow);
            dfs(ROWS-1, i, heights, atlCanFlow);
        }

        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (pacCanFlow[r][c] == true && atlCanFlow[r][c] == true)
                {
                    flow.add(Arrays.asList(r,c));
                }
            }
        }

        return flow;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] canFlow)
    {
        canFlow[row][col] = true;

        for (int[] dir : directions) 
        {
            int r = dir[0] + row;
            int c = dir[1] + col;
        
            if (r >= 0 && c >= 0 && r < ROWS && c < COLS && 
                    heights[r][c] >= heights[row][col] && canFlow[r][c] == false)
            {
                dfs(r, c, heights, canFlow);
            }
        }

    }

    
}
