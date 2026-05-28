class Solution {

    private ArrayList<String> output = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new ArrayList<>());

        return output;
    }

    private void backtrack(int n, int open, int close, ArrayList<String> brackets)
    {
        if (brackets.size() == 2*n)
        {
            output.add(String.join("", brackets));
            return;
        }

        if (open < n)
        {
            brackets.add("(");
            backtrack(n, open + 1, close, brackets);
            brackets.remove(brackets.size() - 1);
        }

        if (close < open)
        {
            brackets.add(")");
            backtrack(n, open, close + 1, brackets);
            brackets.remove(brackets.size() - 1);
        }
    }
}
