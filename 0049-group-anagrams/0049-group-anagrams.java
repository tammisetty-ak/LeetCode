class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap();

        for(String str: strs) {
            int[] chars = new int[26];
            for(char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            
            StringBuilder key = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                if(chars[i] != 0) {
                    key.append((char) i + 'a');
                    key.append(chars[i]);
                }
            }
;
            if(!resMap.containsKey(key.toString())) {
                resMap.put(key.toString(), new ArrayList<String>());
            }
            List<String> list = resMap.get(key.toString());
            list.add(str);
            resMap.put(key.toString(), list);
        }

        List<List<String>> res = new ArrayList();
        for(List<String> vals : resMap.values()) {
            res.add(vals);
        }
        return res;
    }
}