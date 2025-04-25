class MovingAverage {
    List<Integer> queue;
    int targetSize;

    public MovingAverage(int size) {
        queue = new ArrayList();
        targetSize = size;
    }

    public double next(int val) {
        queue.add(val);
        int winsum = 0;
        for(int i = Math.max(0, queue.size() - targetSize); i < queue.size(); i++) {
            winsum += (int) queue.get(i);
        }
        return (winsum * 1.0) / Math.min(queue.size(), targetSize);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */