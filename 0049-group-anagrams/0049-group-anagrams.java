class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        int[] chars = new int[26];
        for(String str: strs) {
            Arrays.fill(chars, 0);
            for(int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            
            StringBuilder temp = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                temp.append('#').append(chars[i]);
            }

            if(!map.containsKey(temp.toString())) {
                map.put(temp.toString(), new ArrayList());
            }
            map.get(temp.toString()).add(str);
        }


        return new ArrayList(map.values());
    }
}