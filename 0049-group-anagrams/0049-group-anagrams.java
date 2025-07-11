class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringToAnaListMap = new HashMap();
        
        for(String str: strs) {
            int[] chars = new int[26];

            for(char c: str.toCharArray()) {
                chars[c - 'a']++;
            }
            String key = Arrays.toString(chars);

            if(!stringToAnaListMap.containsKey(key)) {
                stringToAnaListMap.put(key, new ArrayList());
            }

            stringToAnaListMap.get(key).add(str);
        }

        return new ArrayList<>(stringToAnaListMap.values());

    }
}