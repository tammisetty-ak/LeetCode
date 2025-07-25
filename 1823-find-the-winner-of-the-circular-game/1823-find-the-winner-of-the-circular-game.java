class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            for(int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.peek();
    }
}