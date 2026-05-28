class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        table = defaultdict(list)

        for word in strs:
            s_word = ''.join(sorted(word))
            table[s_word].append(word)
        
        return list(table.values())