class Solution {
    public int[][] highFive(int[][] items) {
        int k = 5;
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap();
        for(int[] item: items) {
            int id = item[0];
            PriorityQueue<Integer> minHeap = map.getOrDefault(id, new PriorityQueue());

            minHeap.offer(item[1]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
            map.put(id, minHeap);
        }
        int[][] res = new int[map.size()][2];
        int i = 0;
        for(int id: map.keySet()) {
            PriorityQueue<Integer> queue = map.get(id);
            int sum = 0;
            while(!queue.isEmpty()) {
                sum += queue.poll();
            }

            res[i][0] = id;
            res[i][1] = sum / k;
            i++;
        }

        return res;

    }
}