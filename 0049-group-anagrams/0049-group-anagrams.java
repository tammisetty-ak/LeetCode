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

            map.putIfAbsent(sb.toString(), new ArrayList());

            if(map.containsKey(sb.toString())){
                List<String> val = map.get(sb.toString());
                val.add(str);
                map.put(sb.toString(), val);
            }

            // map.put(sb.toString(), map.getOrDefault(sb.toString(), new ArrayList()).add(str));
        }

        List<List<String>> res = new ArrayList();
        for(Map.Entry<String, List<String>> e: map.entrySet()) {
            List<String> arr = e.getValue();
            res.add(arr);
        }

        return res;
    }
}