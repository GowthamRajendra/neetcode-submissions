class Solution {

    private HashSet<Pair<Integer, Integer>> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        
        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[r].length; c++)
            {
               if (backtrack(0, r, c, board, word)) return true;
            }
        }

        return false; 
    }

    private boolean backtrack(int i, int r, int c, char[][] board, String word)
    {
        if (i == word.length())
        {
            return true;
        }

        // if out of bounds
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length)
        {
            return false;
        }

        // if seen
        if (visited.contains(new Pair<>(r, c))) return false;

        if (board[r][c] != (word.charAt(i))) return false;

        visited.add(new Pair<>(r, c));
        
        boolean left = backtrack(i + 1, r, c - 1, board, word);
        boolean right = backtrack(i + 1, r, c + 1, board, word);
        boolean up = backtrack(i + 1, r - 1, c, board, word);
        boolean down = backtrack(i + 1, r + 1, c, board, word);
            
        visited.remove(new Pair<>(r, c));

        return left || right || up || down;
    }



}
