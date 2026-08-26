class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> spiral = new ArrayList<>();

        int left = 0;
        int top = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;

        while (left < right && top < bottom)
        {
            for (int i = left; i < right; i++)
            {
                spiral.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i < bottom; i++)
            {
                spiral.add(matrix[i][right-1]);
            }
            right--;

            if (left >= right || bottom <= top) break;

            for (int i = right - 1; i >= left; i--)
            {
                spiral.add(matrix[bottom-1][i]);
            }
            bottom--;

            for(int i = bottom - 1; i >= top; i--)
            {
                spiral.add(matrix[i][left]);
            }
            left++;
        }

        return spiral;
    }
}
