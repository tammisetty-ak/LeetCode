class Solution {

    private String embed(String str) {
        int[] chars = new int[26];
        for(char c: str.toCharArray()) {
            chars[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            if(chars[i] != 0) {
                res.append((char)(i + 'a'));
                res.append(chars[i]);
            }
        }

        return res.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(String str : strs) {
            String embedded = embed(str);

            List<String> list = map.getOrDefault(embedded, new ArrayList());

            list.add(str);

            map.put(embedded, list);
        }

        return new ArrayList(map.values());
    }
}