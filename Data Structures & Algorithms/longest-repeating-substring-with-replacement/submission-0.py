class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        unique = set(s)
        longest = 0

        for char in unique:
            length = 0
            l = 0 
            for r in range(len(s)):
                if s[r] == char:
                    length += 1

                while (r - l + 1) - length > k:
                    if s[l] == char:
                        length -= 1
                    
                    l += 1
                
                longest = max(longest, r - l + 1)
        
        return longest

            
            

