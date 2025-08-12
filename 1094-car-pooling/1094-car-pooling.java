class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> passAtTime = new TreeMap();

        for(int[] trip : trips) {
            int startPassengers = passAtTime.getOrDefault(trip[1], 0) + trip[0];
            passAtTime.put(trip[1], startPassengers);
            int endPassengers = passAtTime.getOrDefault(trip[2], 0) - trip[0];
            passAtTime.put(trip[2], endPassengers);
        }
        int usedCapacity = 0;

        for(int cap: passAtTime.values()) {
            usedCapacity += cap;

            if(usedCapacity > capacity) {
                return false;
            }
        }
                return true;

    }
}