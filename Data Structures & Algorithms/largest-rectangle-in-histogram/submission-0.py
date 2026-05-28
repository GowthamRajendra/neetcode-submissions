class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        maxArea = 0

        for i in range(len(heights)+1):
            while stack and (i==len(heights) or heights[i] <= heights[stack[-1]]):
                h = heights[stack.pop()]
                if not stack:
                    w = i
                else:
                    w = i - stack[-1] - 1
                
                maxArea = max(w*h,maxArea)
            
            stack.append(i)

        return maxArea