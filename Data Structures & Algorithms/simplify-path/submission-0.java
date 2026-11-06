class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");

        for (String dir : dirs)
        {
            if (dir.isEmpty()) continue;

            if (dir.equals(".."))
            {
                if (!stack.isEmpty()) stack.pop();
            }
            else 
            {
                if (!dir.equals(".")) stack.push(dir);
            }
        }

        // string.join reads stack from index 0 to n-1 not LIFO
        return "/" + String.join("/", stack);

    }
}