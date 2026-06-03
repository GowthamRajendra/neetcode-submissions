public class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean end = false;
}

class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
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

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int i, String word, Node root)
    {
        Node node = root;

        for (int j = i; j < word.length(); j++)
        {
            char letter = word.charAt(j);
            
            if (letter == '.')
            {
                for (char c : node.children.keySet())
                {
                    if (dfs(j+1, word, node.children.get(c))) return true;
                }

                return false;
            } 
            else 
            {
                node = node.children.get(letter);

                if (node == null) return false;
            }

        }

        return node.end;
    }




}
