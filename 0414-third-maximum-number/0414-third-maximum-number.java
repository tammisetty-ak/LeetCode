class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> queue = new PriorityQueue();
        Set<Integer> set = new HashSet();

        for(int num: nums) {
            if(set.contains(num)) {
                continue;
            }
            set.add(num);
            queue.offer(num);

            if(queue.size() > 3) {
                int removed = queue.poll();
                // set.remove(removed);
            }
        }

        if(queue.size() == 3) {
            return queue.peek();
        }

        int max = Integer.MIN_VALUE;

        for(int num: queue) {
            max = Math.max(num, max);
        }
        return max;
    }
}