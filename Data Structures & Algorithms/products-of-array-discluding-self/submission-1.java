class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1, 1, 2, 8] [48, 24, 6, 1]
        ArrayList<Integer> prefix = new ArrayList<>();

        prefix.add(1);
        for (int i = 1; i < nums.length; i++)
        {   
            prefix.add(nums[i-1] * prefix.get(i-1));
        }
        
        int [] suffix = new int[nums.length];
        int [] product = new int[nums.length];

        suffix[nums.length-1] = 1;
        product[nums.length-1] = suffix[nums.length-1] * prefix.get(nums.length-1);
        for (int i = nums.length - 2; i > -1; i--)
        {
            suffix[i] = nums[i+1] * suffix[i+1];
            product[i] = suffix[i] * prefix.get(i);

        } 

        return product;
    }

    
}  
