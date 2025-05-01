class StockPrice {

    TreeMap<Integer, Integer> priceCount;
    Map<Integer, Integer> timePrice;
    int latest;

    public StockPrice() {
        timePrice = new HashMap();
        priceCount = new TreeMap();
        latest = 0;
    }
    
    public void update(int timestamp, int price) {
        latest = Math.max(timestamp, latest);
        if(timePrice.containsKey(timestamp)) {
            int oldPrice = timePrice.get(timestamp);
            int count = priceCount.get(oldPrice);
            if(count == 1) {
                priceCount.remove(oldPrice);
            }
            else {
                priceCount.put(oldPrice, count - 1);
            }
        }
        timePrice.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
    }
    
    public int current() {
        return timePrice.get(latest);
    }
    
    public int maximum() {
        return priceCount.lastKey();
    }
    
    public int minimum() {
        return priceCount.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */