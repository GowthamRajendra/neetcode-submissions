class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)

        longest = 0

        for num in nums_set:
            if num - 1 not in nums_set:
                current = 0
                while num + current in nums_set:
                    current += 1
                
                if current > longest:
                    longest = current
        
        return longest
            


