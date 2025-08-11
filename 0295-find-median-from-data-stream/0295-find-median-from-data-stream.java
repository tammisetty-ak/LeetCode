class MedianFinder {
    
    PriorityQueue<Double> minHeap;
    PriorityQueue<Double> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Double>();
        maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());    
    }
    
    public void addNum(int num) {
        maxHeap.offer((double) num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }    
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) * 0.5;
        }
        else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */