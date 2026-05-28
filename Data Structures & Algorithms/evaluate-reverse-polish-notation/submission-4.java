class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++)
        {
            String val = tokens[i];

            if (val.equals("+"))
            {
                stack.push(stack.pop() + stack.pop());
            }
            else if (val.equals("-"))
            {
                int num1 = stack.pop();
                int num2 = stack.pop();

                stack.push(num2 - num1);
            }
            else if (val.equals("*"))
            {
                stack.push(stack.pop() * stack.pop());
            }
            else if (val.equals("/"))
            {
                int num1 = stack.pop();
                int num2 = stack.pop();

                stack.push(num2 / num1);
            }
            else
            {
                stack.push(Integer.parseInt(val));
            }
        }

        return stack.peek();

    }
}
