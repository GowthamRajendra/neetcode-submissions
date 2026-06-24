class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);

        int seqNum = 1;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                String word = queue.poll();

                if (word.equals(endWord)) return seqNum;

                for (int l = 0; l < word.length(); l++)
                {
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        String curr = word.substring(0, l) + c + word.substring(l + 1);

                        if (visited.contains(curr)) continue;

                        if (wordList.contains(curr))
                        {
                            queue.add(curr);
                            visited.add(curr);
                        }
                    }
                }
            }
            seqNum++;
        }

        return 0;

    }
}
