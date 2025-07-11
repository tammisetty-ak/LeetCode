class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, Queue<Integer>> studentIdToScoresMap = new HashMap();

        for(int[] item: items) {
            int studentId = item[0];
            if(!studentIdToScoresMap.containsKey(studentId)) {
                studentIdToScoresMap.put(studentId, new PriorityQueue<Integer>());
            }
            Queue<Integer> minHeap = studentIdToScoresMap.get(studentId);
            minHeap.offer(item[1]);
            if(minHeap.size() > 5) {
                minHeap.poll();
            }
        }
        
        int[][] res = new int[studentIdToScoresMap.size()][2];
        int index = 0, sum = 0;
        for(int studentId: studentIdToScoresMap.keySet()) {
            res[index][0] = studentId;
            sum = 0;
            Queue<Integer> minHeap = studentIdToScoresMap.get(studentId);
            while(!minHeap.isEmpty()) {
                sum += minHeap.poll();
            }
            res[index][1] = sum / 5;
            index++;
        }

        return res;
    }
}