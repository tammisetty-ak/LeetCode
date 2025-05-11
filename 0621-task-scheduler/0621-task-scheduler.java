class Solution {
    public int leastInterval(char[] tasks, int n) {
        int charCounts[] = new int[26];

        for(char task: tasks) {
            charCounts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int res = 0;
        
        for(int charCount : charCounts) {
            if (charCount > 0) {
                maxHeap.offer(charCount);
            }
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

            for(int updatedTasks: store) {
                if(updatedTasks > 0)
                    maxHeap.offer(updatedTasks);
            }

            res += maxHeap.isEmpty() ? taskCount : n + 1;
        }
        return res;
    }
}