/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int l = 1; 
        int r = mountainArr.length() - 2;

        int mtn = -1;

        while (l <= r)
        {
            int m = l + ((r - l) / 2);

            int left = mountainArr.get(m-1);
            int right = mountainArr.get(m+1);
            int mid = mountainArr.get(m);

            if (left < mid && mid < right)
            {
                l = m + 1;
            }
            else if (left > mid && mid > right)
            {
                r = m - 1;
            }
            else  if (left < mid && mid > right)
            {
                mtn = m;
                break;
            }
        }

        l = 0;
        r = mtn - 1;
        
        while (l <= r)
        {
            int m = l + ((r - l) / 2);

            if (target < mountainArr.get(m))
            {
                r = m - 1;
            }
            else if (target > mountainArr.get(m))
            {
                l = m + 1;
            } 
            else {
                return m;
            }
        }

        l = mtn;
        r = mountainArr.length() - 1;
        
        while (l <= r)
        {
            int m = l + ((r - l) / 2);

            if (target < mountainArr.get(m))
            {
                l = m + 1;
            }
            else if (target > mountainArr.get(m))
            {
                r = m - 1;
            } 
            else {
                return m;
            }
        }

        return -1;
    }
}