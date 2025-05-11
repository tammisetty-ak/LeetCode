class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26];

        int res = 0;

        for(char task : tasks) {
            charCounts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

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
                store.add(task - 1);
                taskCount++;
                cycle--;
            }

            for(int task: store) {
                if(task > 0)
                    maxHeap.offer(task);
            }

            res += maxHeap.isEmpty() ? taskCount : n + 1;
        }

        return res;
    }
}