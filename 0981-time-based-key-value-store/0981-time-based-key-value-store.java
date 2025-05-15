class TimeMap {
    private Map<String, ArrayList<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        // 1) key‑not‑present guard
        if (!timeMap.containsKey(key)) {
            return "";
        }
        
        if (timeMap.get(key).get(0).getKey() > timestamp) {
            return "";
        }

        // classic binary search for the last index where ts[idx] <= timestamp
        int left = 0, right = timeMap.get(key).size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int t = timeMap.get(key).get(mid).getKey();
            if (t <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if(right == 0) {
            return "";
        }
        // now right is the largest index with timestamps.get(right) < timestamp
        return timeMap.get(key).get(right - 1).getValue();
    }
}
