class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        nums2 = sorted(nums)

        i = 0
        j = len(nums2) - 1 
        while i != j:
            print(nums2[i],nums2[j])
            if nums2[i] + nums2[j] == target:
                n1 = nums.index(nums2[i])
                if nums2[i] >= nums2[j]:
                    n2 = nums.index(nums2[j], n1+1)
                else:
                    n2 = nums.index(nums2[j])
                return sorted([n1,n2]) 
            elif nums2[i] + nums2[j] < target:
                i += 1
            elif nums2[i] + nums2[j] > target:
                j -= 1
                  
        return []
            