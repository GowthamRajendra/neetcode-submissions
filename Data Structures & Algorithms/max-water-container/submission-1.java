class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int biggest = 0;

        while (l < r)
        {
            int smaller = Math.min(heights[l], heights[r]);

            int area = smaller * (r - l);

            biggest = Math.max(area, biggest);

            if (heights[l] > heights[r])
            {
                r--;
            }
            else 
            {
                l++;
            }
        }

        return biggest;

    }
}
