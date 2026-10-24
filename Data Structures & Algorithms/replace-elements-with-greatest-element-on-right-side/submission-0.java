class Solution {
    public int[] replaceElements(int[] arr) {
        
        int maxi = arr[arr.length - 1];  
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--)
        {
            int temp = maxi;
            maxi = Math.max(arr[i], maxi);
            arr[i] = temp;            
        }

        return arr;
    }
}