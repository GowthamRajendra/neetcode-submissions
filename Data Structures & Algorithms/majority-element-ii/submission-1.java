class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqs = new HashMap<>();

        for (int num : nums)
        {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
            
            if (freqs.size() > 2)
            {
                Iterator<Map.Entry<Integer, Integer>> iterator = freqs.entrySet().iterator();

            while (iterator.hasNext()) 
            {
                Map.Entry<Integer, Integer> set = iterator.next();
            
            
                set.setValue(set.getValue() - 1);

                if (set.getValue() <= 0) 
                {
                    iterator.remove(); 
                }
            }
            }
        }

        List<Integer> elems = new ArrayList<>();

        for (Map.Entry<Integer, Integer> set : freqs.entrySet()) 
        {
            int c = 0;

            for (int num : nums)
            {
                if (num == set.getKey()) c++;
            }

            if (c > nums.length/3) elems.add(set.getKey());
        }

        return elems;
    }
}