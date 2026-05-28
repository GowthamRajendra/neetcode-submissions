class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int []> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++)
        {
            while (!stack.empty() && temperatures[i] > stack.peek()[1])
            {
                int[] pair = stack.pop();
                output[pair[0]] = i - pair[0];
            }

            stack.push(new int[] {i, temperatures[i]});
        }

        return output;

    }
}
