class Solution {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> pos = new HashSet<>();
    HashSet<Integer> neg = new HashSet<>();
    List<List<String>> solved = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] board =  new String[n][n];
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[r].length; c++)
            {
                board[r][c] = ".";
            }
        }

        backtrack(0, n, board);

        return solved;
    }

    private void backtrack(int r, int n, String[][] board)
    {
        if (r == n)
        {
            ArrayList<String> curr = new ArrayList<>();

            for (String[] row : board) {
                curr.add(String.join("", row));
            }

            solved.add(curr);

            return;
        }

        for(int c = 0; c < n; c++)
        {
            if(cols.contains(c) || pos.contains(r+c) || neg.contains(r-c)) continue;
            
            cols.add(c);
            pos.add(r+c);
            neg.add(r-c);
            board[r][c] = "Q";

            backtrack(r+1, n, board);

            cols.remove(c);
            pos.remove(r+c);
            neg.remove(r-c);

            board[r][c] = ".";
        }

    }
}
