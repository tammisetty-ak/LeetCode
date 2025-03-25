class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> mergedIntervals = new LinkedList();

        for(int[] interval: intervals) {
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval [0]) {
                mergedIntervals.add(interval);
            }
            else{
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}