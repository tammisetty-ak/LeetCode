class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];

        for(int[] trip: trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;
        for(int num : timestamp) {
            usedCapacity += num;
            if(usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}