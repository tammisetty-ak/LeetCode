class Solution {

    private int[] getcharCount(String s) {
        int[] charCounts = new int[26];

        for(char c: s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        return charCounts;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(String str: strs) {
            int[] charCounts = getcharCount(str);
            
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < 26; i++) {
                if(charCounts[i] != 0) {
                    sb.append(i + 'a');
                    sb.append(charCounts[i]);
                }
            }

            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList());
            }

            map.get(sb.toString()).add(str);

        }

        return new ArrayList(map.values());
    }
}