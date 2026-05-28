class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top = 0
        bottom = len(matrix) - 1

        while top <= bottom:
            row = top + ((bottom - top) // 2)

            if target < matrix[row][0]:
                bottom = row - 1
            elif target > matrix[row][-1]:
                top = row + 1
            else:
                break

        left = 0
        right = len(matrix[row]) - 1

        while left <= right:
            m = left + ((right - left) // 2)

            if target < matrix[row][m]:
                right = m - 1
            elif target > matrix[row][m]:
                left = m + 1
            else:
                return True
                
        return False