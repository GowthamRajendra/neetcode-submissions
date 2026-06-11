class Solution {
    private int ROWS;
    private int COLS;

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int i = 0 ; i < ROWS; i++)
        {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][COLS-1] == 'O') dfs(i, COLS-1, board);
        }

        for(int i = 0 ; i < COLS; i++)
        {
            if (board[0][i] == 'O') dfs(0, i, board);
            if (board[ROWS-1][i] == 'O') dfs(ROWS-1, i, board);
        }

        for(int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == '#') board[r][c] = 'O'; 
            }
        }
    }


    private void dfs(int row, int col, char[][] board)
    {
        board[row][col] = '#';

        for (int[] dir : directions) 
        {
            int r = dir[0] + row;
            int c = dir[1] + col;
        
            if (r >= 0 && c >= 0 && r < ROWS && c < COLS && board[r][c] == 'O')
            {
                dfs(r, c, board);
            }
        }
    }
}
