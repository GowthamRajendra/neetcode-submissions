class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> regions = new HashMap<>();
        
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char val = board[i][j];

                String regKey = (i/3) + "," + (j/3); 

                if (val != '.')
                {
                    if ((rows.containsKey(i) && rows.get(i).contains(val)) ||
                        (cols.containsKey(j) && cols.get(j).contains(val)) ||
                        (regions.containsKey(regKey) && regions.get(regKey).contains(val)) )
                    {
                        return false;
                    }

                    rows.computeIfAbsent(i, k -> new HashSet<>()).add(board[i][j]);
                    cols.computeIfAbsent(j, k -> new HashSet<>()).add(board[i][j]);
                    regions.computeIfAbsent(regKey, k -> new HashSet<>()).add(board[i][j]);

                }
                
            }
        }

        return true;
    }
}
