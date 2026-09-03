class CountSquares {
    private HashMap<List<Integer>, Integer> coordsCount;
    private List<List<Integer>> coords;

    public CountSquares() {
        coordsCount = new HashMap<>();
        coords = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> coord = Arrays.asList(point[0], point[1]);
        coords.add(coord);
        coordsCount.put(coord, coordsCount.getOrDefault(coord, 0) + 1);
    }
    
    public int count(int[] point) {
        int c = 0;

        for (List<Integer> coord : coords)
        {
            if (point[0] != coord.get(0) && point[1] != coord.get(1))
            {
                int xlen = Math.abs(point[0] - coord.get(0));
                int ylen = Math.abs(point[1] - coord.get(1));

                if (xlen != ylen) continue;

                int p1 = coordsCount.getOrDefault(Arrays.asList(point[0], coord.get(1)), 0);
                int p2 = coordsCount.getOrDefault(Arrays.asList(coord.get(0), point[1]), 0);

                c += p1*p2;

            }
        }

        return c;
    }
}
