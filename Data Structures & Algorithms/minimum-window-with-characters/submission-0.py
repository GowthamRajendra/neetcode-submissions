class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "" or len(t) > len(s):
            return ""

        freqs = defaultdict(int)

        for i in t:
            freqs[i] += 1
        
        substr = defaultdict(int)
        shortest = ""
        shortestLen = float('inf')
        current = 0
        l = 0

        for r in range(len(s)):
            substr[s[r]] += 1

            if s[r] in freqs and substr[s[r]] == freqs[s[r]]:
                current += 1
            
            while current == len(freqs):
                if (r - l + 1) < shortestLen:
                    shortest = s[l:r+1]
                    shortestLen = r - l + 1
                
                substr[s[l]] -= 1

                if s[l] in freqs and substr[s[l]] < freqs[s[l]]:
                    current -= 1
                
                l += 1
        
        return shortest




