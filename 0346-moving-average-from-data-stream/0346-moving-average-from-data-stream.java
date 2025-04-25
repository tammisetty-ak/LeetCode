class MovingAverage {
    Queue<Integer> queue;
    int targetSize;

    public MovingAverage(int size) {
        queue = new LinkedList();
        targetSize = size;
    }

    public double next(int val) {
        if(queue.size() == targetSize) {
            queue.poll();
        }
        queue.offer(val);
        int sum = findSum(queue);
        return sum / (double) queue.size();
    }

    public int findSum(Queue<Integer> temp) {
        Queue<Integer> tempQueue = new LinkedList<>(temp);
        int sum = 0;
        while (!tempQueue.isEmpty()) {
            sum += tempQueue.poll();
        }

        return sum;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */