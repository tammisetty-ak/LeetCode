class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            Arrays.fill(count, 0);
            sb.setLength(0);

            for(char c: str.toCharArray()) {
                count[c - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                if(count[i] != 0) {
                    sb.append(i + 'a');
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }

            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}