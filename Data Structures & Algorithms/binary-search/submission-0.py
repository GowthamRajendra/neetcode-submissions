class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        left = 0
        right = len(nums) - 1

        while left <= right:
            m = left + ((right - left) // 2)

            if target < nums[m]:
                right = m - 1
            elif target > nums[m]:
                left = m + 1
            else:
                return m
            
        return -1