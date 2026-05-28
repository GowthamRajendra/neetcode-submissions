class Solution {

    public String encode(List<String> strs) {
        String code = "";
        String message = "";

        for (String s : strs)
        {
            code += s.length() + ",";
            message += s;
        }

        return code + "#" + message;
    }

    public List<String> decode(String str) {
        
        ArrayList<String> message = new ArrayList<>();

        String[] splitMsg = str.split(",#", 2);

        if (splitMsg.length < 2)
        {
            return message;
        }

        for(String s : splitMsg)
        {
             System.out.println(s + "as");
        }

        String[] lengths = splitMsg[0].split(",");

        int ptr = 0;
        for (String l : lengths)
        { 
            int len = Integer.parseInt(l);
            message.add(splitMsg[1].substring(ptr,ptr+len));
            ptr += len;
        }

        return message;

    }
}
