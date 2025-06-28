class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int[] item: items) {
            int id = item[0];
            PriorityQueue<Integer> queue = map.getOrDefault(id, new PriorityQueue<>(Collections.reverseOrder()));
            queue.offer(item[1]);
            map.put(id, queue);
        }

        int[][] res = new int[map.size()][2];
        int i = 0;

        for(int key : map.keySet()) {
            int top = 0;
            int sum = 0;
            PriorityQueue <Integer> queue = map.get(key);
            while(top++ < 5) {
                sum += queue.poll();
            }
            int[] temp = { key, sum / 5 };
            res[i++] = temp;
        }

        return res;
    }
}