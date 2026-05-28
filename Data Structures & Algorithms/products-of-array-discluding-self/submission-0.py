class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1]

        for i in range(1,len(nums)):
            prefix.append(nums[i-1] * prefix[i-1])
        
        suffix = [0] * len(nums)
        suffix[-1] = 1

        for i in range(len(nums)-2, -1, -1):
            suffix[i] = nums[i+1] * suffix[i+1]

        output = []

        for i in range(len(nums)):
            output.append(suffix[i] * prefix[i])
        
        return output

