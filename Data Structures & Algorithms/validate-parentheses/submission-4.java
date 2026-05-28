class Solution {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        
        HashMap<Character, Character> matches = new HashMap<>();
        matches.put(')', '(');
        matches.put(']', '[');
        matches.put('}', '{');

        for (int i = 0; i < s.length(); i++)
        {
            if ( !myStack.empty() && matches.containsKey(s.charAt(i)))
            {
                char val = myStack.pop();

                if (val != matches.get(s.charAt(i)))
                {
                    return false;
                }
            } 
            else 
            {
                myStack.push(s.charAt(i));
            }

        }

        return myStack.empty();


    }
}
