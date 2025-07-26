class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        
        int min = Integer.MAX_VALUE;

        for(int value : map.values()) {
            min = Math.min(value, min);
        }
        
        if(min > 1) {
            for(int card: map.keySet()) {
                while(map.get(card) >= 0) {
                    if(map.get(card) % min != 0) {
                        return false;
                    }
                    map.put(card, map.get(card) - min);
                }
            }
            return true;
        }

        return false;
    }
}