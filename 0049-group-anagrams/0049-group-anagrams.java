class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] charArr = new int[26];

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            Arrays.fill(charArr, 0);
            for(Character c: s.toCharArray()){
                charArr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 26; i++){
                sb.append('#');
                sb.append(charArr[i]);
            }

            String ans = sb.toString();

            map.computeIfAbsent(ans, k -> new ArrayList()).add(s);
        }

        return new ArrayList(map.values());
    }
}