class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        // int[][] output = new int[][];

        // output[0] = intervals[0];

        // for (int i = 1; i < intervals.length; i++) {
        //     if (output[i - 1][1] >= intervals[i][0]) {
        //         output[i - 1][1] = Math.max(intervals[i][1], output[i - 1][1]);
        //     }
        //     else
        //         output[i] = intervals[i];

        // }

        // return output;


        for(int[] interval: intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}