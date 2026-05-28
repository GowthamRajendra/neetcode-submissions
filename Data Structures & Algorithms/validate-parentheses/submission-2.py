class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        matches = {']':'[', '}':'{', ')':'(' }

        for i in s:
            if stack and i in matches.keys():
                if stack[-1] != matches[i]:
                    return False
                else:
                    stack.pop()
            else:
                stack.append(i)        
        
        return len(stack) == 0