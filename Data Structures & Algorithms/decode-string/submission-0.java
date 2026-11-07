class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char l : s.toCharArray())
        {
            if (l == ']')
            {
                StringBuilder curr = new StringBuilder();

                while (!stack.peek().equals("["))
                {
                    curr.insert(0, stack.pop());
                }
                stack.pop(); // pop [

                StringBuilder k = new StringBuilder();

                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)))
                {
                    k.insert(0, stack.pop());
                }

                StringBuilder repeats = new StringBuilder();

                for (int i = 0; i < Integer.parseInt(k.toString()) ; i++)
                {
                    repeats.append(curr);
                }

                stack.push(repeats.toString());
            }
            else 
            {
                stack.push(String.valueOf(l));
            }
        }

        StringBuilder decoded = new StringBuilder();
        while(!stack.isEmpty())
        {
            decoded.insert(0, stack.pop());
        }

        return decoded.toString();
    }
}