class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26];

        for(char ch : tasks) {
            charCounts[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int time = 0;

        for(int i = 0; i < 26; i++) {
            if(charCounts[i] > 0) {
                maxHeap.offer(charCounts[i]);
            }
        }

        while(!maxHeap.isEmpty()) {
            int cycle = n + 1;

            List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            while(cycle > 0 && !maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                if (curr > 1) {
                    store.add(curr - 1);
                }
                taskCount++;
                cycle--;
            }

            store.forEach(maxHeap::offer);

            time += maxHeap.isEmpty() ? taskCount : n + 1;
        }       
        return time;
    }
}