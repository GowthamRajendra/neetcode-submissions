class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();


        for (int i = 0; i < numbers.length; i++)
        {
            seen.put(numbers[i], i);

            int comp = target - numbers[i];

            if ( seen.containsKey(comp) && seen.get(comp) != i)
            {
                return new int[] {seen.get(comp) + 1, i + 1};
            }
        }
    
        return new int[] {};
    }
}
