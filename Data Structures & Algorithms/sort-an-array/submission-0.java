class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }


    private void mergeSort(int[] nums, int l, int r)
    {
        if (l == r) return;

        int m = (l+r)/2;

        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r)
    {
        int[] left = Arrays.copyOfRange(nums, l, m+1);
        int[] right = Arrays.copyOfRange(nums, m+1, r+1);

        int i = l; // for nums 
        int j = 0; // left array 
        int k = 0; // right array

        while (j < left.length && k < right.length)
        {
            if (left[j] <= right[k])
            {
                nums[i] = left[j];
                j++;
            }
            else 
            {
                nums[i] = right[k];
                k++;
            }

            i++;
        }

        // left has values left
        while (j < left.length)
        {
            nums[i] = left[j];
            i++;
            j++;
        }

        // right has values left
        while (k < right.length)
        {
            nums[i] = right[k];
            i++;
            k++;
        }
    }


}