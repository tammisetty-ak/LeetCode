class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap();

        for(int[] trip: trips) {
            int startPassengers = trip[0];
            map.put(trip[1], map.getOrDefault(trip[1], 0) + startPassengers);
            int endPassengers = map.getOrDefault(trip[2], 0) - trip[0];
            map.put(trip[2], endPassengers);
        }

        int usedCapacity = 0;
        for(int time: map.keySet()) {
            usedCapacity += map.get(time);
            if(usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}