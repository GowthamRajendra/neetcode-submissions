class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0; 
        int r = arr.length - 1;

        while (r-l >= k)
        {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x))
            {
                r--;
            }
            else 
            {
                l++;
            }
        }

        List<Integer> closest = new ArrayList<>();

        for(int i = l; i <= r; i++)
        {
            closest.add(arr[i]); 
        }

        return closest;
    }
}