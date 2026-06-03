public class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean end = false;
}

class Solution {

    Node root;
    private HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
    private HashSet<String> found = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();

        for (String word : words) {
            addWord(word);
        }

        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[r].length; c++)
            {
               backtrack(r, c, board, "", root);
            }
        }
        
        return new ArrayList<>(found);
    }

    private void backtrack(int r, int c, char[][] board, String word, Node node)
    {
        // if out of bounds
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length)
        {
            return;
        }

        // if seen
        if (visited.contains(new Pair<>(r, c))) return;

        if (!node.children.containsKey(board[r][c])) return;

        visited.add(new Pair<>(r, c));

        node = node.children.get(board[r][c]);
        word += board[r][c];

        if (node.end) found.add(word);
        
        backtrack(r, c - 1, board, word, node);
        backtrack(r, c + 1, board, word, node);
        backtrack(r - 1, c, board, word, node);
        backtrack(r + 1, c, board, word, node);
            
        visited.remove(new Pair<>(r, c));
    }

    public void addWord(String word) {
        Node letter = root;

        for(int i = 0; i < word.length(); i++)
        {
            letter.children.putIfAbsent(word.charAt(i), new Node());
            letter = letter.children.get(word.charAt(i));
        }

        letter.end = true;
    }
}
