class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        output = [0] * len(temperatures)


        for i in range(len(temperatures)):
            while stack and stack[-1][1] < temperatures[i]:
                index, temp = stack.pop()
                output[index] = i - index 

            stack.append((i, temperatures[i]))

        return output
            