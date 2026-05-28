class Solution:
    def trap(self, height: List[int]) -> int:
        myStack = []

        area = 0

        for i in range(len(height)):
            while myStack and height[i] >= height[myStack[-1]]:
                print(i, myStack)
                bottom = height[myStack.pop()]

                if myStack:
                    h = min(height[i], height[myStack[-1]]) - bottom
                    w = i - myStack[-1] - 1
                    area += h*w
            
            myStack.append(i)

        return area