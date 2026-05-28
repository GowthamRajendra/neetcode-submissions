class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        freqs1 = defaultdict(int)

        for i in s1:
            freqs1[i] += 1

        l = 0
        r = len(s1) - 1

        while r < len(s2):
            freqs2 = defaultdict(int)
            for i in range(l, r+1):
                freqs2[s2[i]] += 1
            
            if freqs1 == freqs2:
                return True
            l += 1
            r += 1
        
        return False
                