class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1

        while l < r:
            m = l + ((r - l)//2)

            if nums[m] >= nums[r]:
                l = m + 1
            elif nums[m] <= nums[r]:
                r = m 
        
        left = 0 
        right = len(nums) - 1

        if target >= nums[l] and target <= nums[right]:
            left = l
        else:
            right = l - 1  
        
        while left <= right:
            mid = left + ((right - left) // 2)

            if target < nums[mid]:
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1
            else:
                return mid
            
        return -1




