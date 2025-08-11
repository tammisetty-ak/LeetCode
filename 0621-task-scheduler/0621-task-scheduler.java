class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26];

        for(char c : tasks) {
            charCounts[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < 26; i++) {
            if(charCounts[i] != 0) {
                maxHeap.offer(charCounts[i]);
            }
        }
        int res = 0;
        while(!maxHeap.isEmpty()) {
            int cycle = n + 1;

            int taskCount = 0;
            ArrayList<Integer> store = new ArrayList();

            while(cycle > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                if(task > 1) {
                    store.add(task - 1);
                }
                taskCount++;
                cycle--;
            }

            for(int updatedTask: store) {
                maxHeap.offer(updatedTask);
            }

            res += maxHeap.isEmpty()? taskCount : n + 1;
        }
        return res;
    }
}