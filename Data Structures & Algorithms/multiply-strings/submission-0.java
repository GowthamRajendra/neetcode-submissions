class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] prod = new int[len1+len2];

        for (int i = len1 - 1; i >=0; i--)
        {
            for (int j = len2 - 1; j >=0; j--)
            {
                int curr = (num2.charAt(j) - 48) * (num1.charAt(i) - 48);

                prod[i + j + 1] += curr;
                prod[i + j] += prod[i + j + 1] / 10;
                prod[i + j + 1] %= 10; 
            }
        }

        String out = "";

        for (int i = 0; i < prod.length; i++)
        {
            if (i == 0 && prod[i] == 0) continue;

            out += prod[i];
        }

        return out;
    }
}
