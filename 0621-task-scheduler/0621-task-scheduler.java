class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26];

        for(int i = 0; i < tasks.length; i++) {
            charCounts[tasks[i] - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });

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