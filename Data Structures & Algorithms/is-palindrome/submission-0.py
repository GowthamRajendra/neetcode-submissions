class Solution:
    def isPalindrome(self, s: str) -> bool:
        s =  ''.join(char for char in s if char.isalnum())
        
        ptr1 = 0
        ptr2 = len(s) - 1

        for i in range(len(s)//2):
            if s[ptr1].lower() != s[ptr2].lower():
                return False
            ptr1 += 1
            ptr2 -= 1
        
        return True