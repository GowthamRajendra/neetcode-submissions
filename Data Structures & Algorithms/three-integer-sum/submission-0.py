class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        print(nums)
        output = []

        for i in range(len(nums)):
            if nums[i] > 0:
                break
            
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            p1 = i + 1
            p2 = len(nums) - 1

            while p1 < p2:
                val = nums[p1] + nums[p2]

                if val < -nums[i]:
                    p1 += 1
                elif val > -nums[i]:
                    p2 -= 1
                else:
                    output.append([nums[i], nums[p1], nums[p2]])
                    p1 += 1
                    p2 -= 1

                    while p1 < p2 and nums[p1] == nums[p1 - 1]:
                        p1 += 1


        
        return output