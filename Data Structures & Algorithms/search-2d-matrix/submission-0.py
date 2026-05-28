class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        for arr in matrix:
            if target >= arr[0] and target <= arr[-1]:
                left = 0
                right = len(arr) - 1

                while left <= right:
                    m = left + ((right - left) // 2)

                    if target < arr[m]:
                        right = m - 1
                    elif target > arr[m]:
                        left = m + 1
                    else:
                        return True
                    
        return False