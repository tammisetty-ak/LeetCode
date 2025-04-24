class Solution {
    char shiftLetter(char letter, int shift) {
            return (char) ((letter - shift + 26) % 26 + 'a');
    }

    public String getHash(String str) {
        char[] chars = str.toCharArray();

        int shift = chars[0];
        for(int i =0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }

        String hashKey = String.valueOf(chars);
        return hashKey;
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strings) {
            String str = getHash(s);
            map.putIfAbsent(str, new ArrayList());
            map.get(str).add(s);
        }
        
        List<List<String>> res = new ArrayList();

        for(Map.Entry<String, List<String>> e: map.entrySet()) {
            List<String> temp = e.getValue();
            res.add(temp);
        }
        return res;

        
    }
}