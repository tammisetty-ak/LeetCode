class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26];

        for(char task: tasks) {
            charCounts[task - 'A']++;
        }
        int res = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int charCount: charCounts) {
            if(charCount > 0)
                maxHeap.offer(charCount);
        }

        while(!maxHeap.isEmpty()) {
            int cycle = n + 1;


            List<Integer> store = new ArrayList();
            int taskCount = 0;
            while(cycle > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                if(task > 1) {
                    store.add(task - 1);
                }
                taskCount++;
                cycle--;
            }

            for(int s: store) {
                maxHeap.offer(s);
            }

            res += maxHeap.isEmpty() ? taskCount : n + 1;
        }

        return res;
    }
}