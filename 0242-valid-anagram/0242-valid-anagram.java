class Solution {
    private HashMap<Character, Integer> createMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = createMap(s);
        HashMap<Character, Integer> map2 = createMap(t);

        return map1.equals(map2);
    }
}