class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> studentTop5 = new TreeMap();
        for(int[] item : items) {
            if(!studentTop5.containsKey(item[0])) {
                studentTop5.put(item[0], new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> queue = studentTop5.get(item[0]);
            queue.offer(item[1]);
            if(queue.size() > 5) {
                queue.poll();
            }
        }
        
        int[][] res = new int[studentTop5.size()][2];
        int i = 0;

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry: studentTop5.entrySet()) {
            int studentId = entry.getKey();
            PriorityQueue<Integer> marks = entry.getValue();
            int sum = 0;
            while(!marks.isEmpty()) {
                sum += marks.poll();
            }
            res[i][0] = studentId;
            res[i][1] = sum / 5;
            i++;
        }

        return res;
    }
}