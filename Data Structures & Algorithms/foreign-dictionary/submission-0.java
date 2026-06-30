class Solution {
    HashMap<Character, HashSet<Character>> adjMap = new HashMap<>();
    HashMap<Character, Boolean> visited = new HashMap<>();
    ArrayList<Character> order = new ArrayList<>();

    public String foreignDictionary(String[] words) {
        
        for (String word : words)
        {
            for (int i = 0; i < word.length(); i++)
            {
                adjMap.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++)
        {
            String w1 = words[i];
            String w2 = words[i+1];

            if (w1.startsWith(w2) && w1.length() > w2.length()) return "";

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++)
            {
                if (w1.charAt(j) != w2.charAt(j)) 
                {
                    adjMap.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for (Map.Entry<Character, HashSet<Character>> set : adjMap.entrySet()) 
        {
            if (dfs(set.getKey())) return "";
        }

        Collections.reverse(order);

        StringBuilder sb = new StringBuilder();

        for (char c : order)
        {
            sb.append(c);
        }

        return sb.toString();

    }

    private boolean dfs(char c)
    {
        if (visited.containsKey(c)) return visited.get(c);

        visited.put(c, true);

        for (char l : adjMap.get(c))
        {
            if (dfs(l)) return true;
        }

        visited.put(c, false);
        order.add(c);

        return false;
    }
}
