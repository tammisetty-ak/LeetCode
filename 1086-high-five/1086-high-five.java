class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue> map = new HashMap();
        for(int[] item: items) {
            int id = item[0];
            PriorityQueue<Integer> minHeap = map.getOrDefault(id, new PriorityQueue());

            minHeap.offer(item[1]);
            if(minHeap.size() > 5) {
                minHeap.poll();
            }
            map.put(id, minHeap);
        }
        int[][] res = new int[map.size()][2];
        int i = 0;
        for(int key: map.keySet()) {
            int[] temp = new int[2];
            temp[0] = key;
            PriorityQueue<Integer> queue = map.get(key);
            int sum = 0;
            while(!queue.isEmpty()) {
                sum += queue.poll();
            }
            temp[1] = sum / 5;

            res[i++] = temp;
        }

        return res;

    }
}