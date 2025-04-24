class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            int[] charCount = new int[26];
            for(char c: s.toCharArray()) {
                charCount[c - 'a']++;
            }

            StringBuilder res = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                while(charCount[i]-- > 0) {
                    res.append(i + 'a');
                }
            }

            map.putIfAbsent(res.toString(), new ArrayList());
            map.get(res.toString()).add(s);
        }

        List<List<String>> res = new ArrayList();

        for(Map.Entry<String, List<String>> e: map.entrySet()) {
            List<String> temp = e.getValue();
            res.add(temp);
        }

        return res;
    }
}