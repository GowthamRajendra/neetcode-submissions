class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        for i in range(len(numbers)):
            complement = target - numbers[i]

            low = i + 1
            high = len(numbers) - 1

            while low <= high:
                mid = low + (high - low) // 2

                if complement == numbers[mid]:
                    return [i + 1, mid + 1]
                elif complement < numbers[mid]:
                    high = mid - 1
                elif complement > numbers[mid]:
                    low = mid + 1
        
        return []



