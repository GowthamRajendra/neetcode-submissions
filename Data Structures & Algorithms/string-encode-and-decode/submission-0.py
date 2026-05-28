class Solution:

    def encode(self, strs: List[str]) -> str:
        order = ''
        words = ''

        for s in strs:
            order += str(len(s)) + ','
            words += s 
        
        return order + '#' + words

    def decode(self, s: str) -> List[str]:
        output = []

        msg = s.split('#', 1) 

        lens = msg.pop(0).split(',')
        lens.pop()
        
        ptr = 0
        for i in lens:
            output.append(msg[0][ptr:ptr+int(i)])
            ptr += int(i)

        return output      



