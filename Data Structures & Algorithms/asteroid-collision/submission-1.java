class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int curr : asteroids)
        {
            // curr got destroyed
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && curr < 0)
            {
                int popped = stack.pop();

                if (Math.abs(popped) > Math.abs(curr))
                {
                    stack.push(popped);
                    destroyed = true;
                    break;
                }
                else if (Math.abs(popped) == Math.abs(curr))
                {
                    destroyed = true;
                    break;
                }
            }
            
            if (!destroyed)
            {
                stack.push(curr);
            }
        }

        int[] asters = new int[stack.size()];

        for (int i = asters.length - 1; i >= 0 ;i--)
        {
            asters[i] = stack.pop();
        }

        return asters;
    }
}