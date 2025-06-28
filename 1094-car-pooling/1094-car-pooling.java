class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap();

        for(int[] trip : trips) {
            int startPassengers = map.getOrDefault(trip[1], 0) + trip[0];
            map.put(trip[1], startPassengers);
            int endPassengers = map.getOrDefault(trip[2], 0) - trip[0];
            map.put(trip[2], endPassengers);
        }

        int usedCapacity = 0;

        for(int passengerChange : map.values()) {
            usedCapacity += passengerChange;
            if(usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}