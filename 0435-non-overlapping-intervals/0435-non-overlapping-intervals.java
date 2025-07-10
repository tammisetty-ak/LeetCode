class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prev = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(prev > intervals[i][0]) {
                count++;
            }
            else {
                prev = intervals[i][1];
            }
        }

        return count;

    }
}

// 1 2, 2 3, 3 4, 1 3
// 1 2, 2 3, 1 3, 3 4

// 0 2 1 3 2 4 3 5 4 6
// 0 2 2 4 