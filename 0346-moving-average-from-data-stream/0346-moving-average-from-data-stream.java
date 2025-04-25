class MovingAverage {
    Queue<Integer> queue;
    int count = 0, winSum = 0;
    int targetSize;

    public MovingAverage(int size) {
        queue = new ArrayDeque();
        targetSize = size;
    }

    public double next(int val) {
        count++;
        queue.add(val);
        int winsum = 0;
        int tail = count > targetSize ? (int) queue.poll() : 0;

        winSum = winSum - tail + val;

        return (winSum * 1.0) / Math.min(count, targetSize);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */