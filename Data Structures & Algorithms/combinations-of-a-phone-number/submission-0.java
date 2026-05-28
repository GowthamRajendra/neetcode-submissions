class Solution {

    ArrayList<String> combs = new ArrayList<>();
    String[] letters = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<String>();

        backtrack(0, digits, "");

        return combs;
    }

    private void backtrack(int i, String digits, String comb)
    {
        if (i == digits.length())
        {
            combs.add(comb);
            return;
        }

        String curr = letters[ digits.charAt(i) - '0' ]; 
        
        for (int j = 0; j < curr.length(); j++)
        {
            comb += curr.charAt(j);
            backtrack(i+1, digits, comb);
            comb = comb.substring(0, comb.length() - 1);
        }
    }

}
