class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false; 

        HashMap<Integer, Integer> freqs = new HashMap<>();

        for (int i = 0; i < hand.length; i++)
        {
            freqs.put(hand[i], freqs.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++)
        {
            if (freqs.get(hand[i]) == 0) continue;

            for (int num = hand[i]; num < hand[i] + groupSize; num++)
            {
                if (freqs.getOrDefault(num, 0) == 0) return false;

                freqs.put(num, freqs.get(num) - 1);
            }
        }


        return true;
    }
}
