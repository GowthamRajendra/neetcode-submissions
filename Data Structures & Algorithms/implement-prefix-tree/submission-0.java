public class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean end = false;
}

class PrefixTree {

    Node root;

    public PrefixTree() {
        root = new Node(); 
    }

    public void insert(String word) {

        Node letter = root;

        for(int i = 0; i < word.length(); i++)
        {
            letter.children.putIfAbsent(word.charAt(i), new Node());
            letter = letter.children.get(word.charAt(i));
        }

        letter.end = true;
    }

    public boolean search(String word) {

        Node letter = root;

        for (int i = 0; i < word.length(); i ++)
        {
            if (!letter.children.containsKey(word.charAt(i))) return false;

            letter = letter.children.get(word.charAt(i));
        }

        return letter.end;
    }

    public boolean startsWith(String prefix) {

        Node letter = root;

        for (int i = 0; i < prefix.length(); i ++)
        {
            if (!letter.children.containsKey(prefix.charAt(i))) return false;

            letter = letter.children.get(prefix.charAt(i));
        }

        return true;
    }
}
