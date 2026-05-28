class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        nums_map = defaultdict(int)

        for i in range(len(numbers)):
            nums_map[numbers[i]] = i
        
        for i in range(len(numbers)):
            complement = target - numbers[i]
            if complement in nums_map.keys() and i != nums_map[complement]:
                return [i + 1, nums_map[complement] + 1]
            
        return []


