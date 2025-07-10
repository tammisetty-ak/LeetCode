class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(String str: strs) {
            int[] chars = new int[26];

            for(int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            
            StringBuilder temp = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                if(chars[i] > 0) {
                    temp.append(i + 'a').append(chars[i]);
                }
            }

            if(!map.containsKey(temp.toString())) {
                map.put(temp.toString(), new ArrayList());
            }
            map.get(temp.toString()).add(str);
        }

        List<List<String>> res = new ArrayList();

        for(String key: map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }
}