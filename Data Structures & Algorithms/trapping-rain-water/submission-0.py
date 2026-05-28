class Solution:
    def trap(self, height: List[int]) -> int:
        
        left = 0 
        leftMax = height[left]
        right = len(height) - 1
        rightMax = height[right]

        area = 0
        
        while left < right:
            
            if leftMax < rightMax:
                left += 1
                leftMax = max(leftMax, height[left])
                area += leftMax - height[left]
            else: 
                right -= 1
                rightMax = max(rightMax, height[right])
                area += rightMax - height[right]
            
        return area


