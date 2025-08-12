class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap();

        for(String str: strs) {
            int[] chars = new int[26];
            for(char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                if(chars[i] != 0) {
                    sb.append((char) i + 'a');
                    sb.append(chars[i]);
                }
            }
            String key = sb.toString();
            if(!resMap.containsKey(key)) {
                resMap.put(key, new ArrayList<String>());
            }
            List<String> list = resMap.get(key.toString());
            list.add(str);
            resMap.put(key, list);
        }

        return new ArrayList<>(resMap.values());
        
    }
}