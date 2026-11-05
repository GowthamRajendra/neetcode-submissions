class StockSpanner {
    private List<Integer> stocks;

    public StockSpanner() {
        stocks = new ArrayList<>();
    }
    
    public int next(int price) {
        int i = stocks.size() - 1;

        while (i >= 0)
        {
            if (stocks.get(i) > price) break;
            i--;
        }

        stocks.add(price);

        return stocks.size() - i - 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */