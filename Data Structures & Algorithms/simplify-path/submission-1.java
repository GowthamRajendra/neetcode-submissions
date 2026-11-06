class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/");

        for (String dir : dirs)
        {
            if (dir.isEmpty() || dir.equals(".")) continue;

            if (dir.equals(".."))
            {
                if (!stack.isEmpty()) stack.pop();
            }
            else 
            {
                stack.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            String last = stack.pollLast();
            sb.append("/");
            sb.append(last);
        }
        
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}