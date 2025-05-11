class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        List<int[]> merged = new ArrayList();
        int[] last = intervals[0];
        merged.add(last);

        for(int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart <= last[1]) {
                last[1] = Math.max(last[1], currEnd);
            }
            else{
                last = intervals[i];
                merged.add(last);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}