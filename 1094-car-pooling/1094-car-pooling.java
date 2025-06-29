class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] trip = new int[1001];

        for(int[] t : trips) {
            trip[t[1]] += t[0];
            trip[t[2]] -= t[0];
        }

        int usedCapacity = 0;
        for(int t: trip) {
            if(t != 0) {
                usedCapacity += t;
                if(capacity < usedCapacity) {
                    return false;
                }
            }
        }
        return true;
    }
}