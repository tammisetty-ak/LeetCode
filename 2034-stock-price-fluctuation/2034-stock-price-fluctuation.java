class StockPrice {

    TreeMap<Integer, Integer> timemap;
    PriorityQueue<int[]> minHeap, maxHeap;
    int latest;

    public StockPrice() {
        timemap = new TreeMap();
        minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        latest = 0;
    }
    
    public void update(int timestamp, int price) {
        latest = Math.max(timestamp, latest);
        timemap.put(timestamp, price);

        minHeap.add(new int[] {price, timestamp});
        maxHeap.add(new int[] {price, timestamp});
    }
    
    public int current() {
        return timemap.get(latest);
    }
    
    public int maximum() {
        int[] top = maxHeap.peek();

        while(timemap.get(top[1]) != top[0]) {
            maxHeap.remove();
            top = maxHeap.peek();
        }

        return top[0];
    }
    
    public int minimum() {
        int[] top = minHeap.peek();

        while(timemap.get(top[1]) != top[0]) {
            minHeap.remove();
            top = minHeap.peek();
        }

        return top[0];
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