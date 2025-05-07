class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
// 3 2 1 5 6
        for(int num: nums){
            minHeap.add(num);
            // 5 6
            if(minHeap.size() > k){
                minHeap.remove();
                // 5 6

            }
        }

        return minHeap.peek();
    }
}