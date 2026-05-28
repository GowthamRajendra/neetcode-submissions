class TimeMap {
    
    HashMap<String, List<Pair<Integer, String>>> timemap;

    public TimeMap() {
        timemap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (timemap.containsKey(key))
        {
            timemap.get(key).add(new Pair<>(timestamp, value));
        }
        else 
        {
            ArrayList<Pair<Integer, String>> temp = new ArrayList<>();

            temp.add(new Pair<>(timestamp, value));

            timemap.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> vals = timemap.getOrDefault(key, new ArrayList<>());

        String out = "";
        int l = 0;
        int r = vals.size() - 1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;

            if (vals.get(m).getKey() <= timestamp)
            {
                l = m + 1;
                out = vals.get(m).getValue();
            }
            else if (vals.get(m).getKey() > timestamp)
            {
                r = m -1;
            } 
        }

        return out;
    }
}
