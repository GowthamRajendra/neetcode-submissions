class Solution {
    private int ROWS;
    private int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> flow = new ArrayList<>();

        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacCanFlow = new boolean[ROWS][COLS];
        boolean[][] atlCanFlow = new boolean[ROWS][COLS];

        LinkedList<int[]> pacQ = new LinkedList<>();
        LinkedList<int[]> atlQ = new LinkedList<>();

        for(int i = 0 ; i < ROWS; i++)
        {
            initColls(pacQ, pacCanFlow, i, 0);
            initColls(atlQ, atlCanFlow, i, COLS-1);
        }

        for(int i = 0 ; i < COLS; i++)
        {
            initColls(pacQ, pacCanFlow, 0, i);
            initColls(atlQ, atlCanFlow, ROWS-1, i);
        }

        bfs(pacQ, heights, pacCanFlow);
        bfs(atlQ, heights, atlCanFlow);

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

    private void initColls(LinkedList<int[]> queue, boolean[][] canFlow, int r, int c)
    {
        canFlow[r][c] = true;
        queue.add(new int[] {r, c});
    }

    private void bfs(LinkedList<int[]> queue, int[][] heights, boolean[][] canFlow)
    {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) 
            {
                int r = dir[0] + row;
                int c = dir[1] + col;

                if (r >= 0 && c >= 0 && r < ROWS && c < COLS && 
                    heights[r][c] >= heights[row][col] && canFlow[r][c] == false)
                {
                    queue.add(new int[] {r, c});
                    canFlow[r][c] = true;
                }

            }

        }
    }



}
