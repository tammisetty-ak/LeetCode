class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> {
            return map.get(a) - map.get(b);
        });

        for(int key: map.keySet()) {
            heap.offer(key);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }
}