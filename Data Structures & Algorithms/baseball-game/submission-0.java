class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stak = new Stack<>();

        int score = 0; 

        for (String op : operations)
        {
            if (op.equals("+") && stak.size() >= 2)
            {
                int s = stak.pop();
                int dble = s + stak.peek();

                stak.push(s);
                stak.push(dble);
                score += dble;
            } 
            else if (op.equals("D"))
            {
                stak.push(stak.peek() * 2);
                score += stak.peek();
            }
            else if (op.equals("C"))
            {
                score -= stak.pop();
            }
            else 
            {
                stak.push(Integer.parseInt(op));
                score += stak.peek();
            }
        }

        return score;
    }
}