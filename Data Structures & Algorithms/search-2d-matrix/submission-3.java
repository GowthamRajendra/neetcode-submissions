class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        int midRow = -1;

        while (top <= bottom)
        {
            midRow = top + (bottom - top) / 2;
            
            if (target > matrix[midRow][cols-1])
            {
                top = midRow + 1;
            } 
            else if (target < matrix[midRow][0])
            {
                bottom = midRow - 1;
            }
            else 
            {
                break;
            }
        }
        if (!(top <= bottom)) {
            return false;
        }

        int l = 0;
        int r = cols - 1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;

            if (target < matrix[midRow][m])
            { 
                r = m - 1;   
            }
            else if (target > matrix[midRow][m])
            {
                l = m + 1;
            }
            else 
            {
                return true;
            }
        }

        return false;

    }
}
