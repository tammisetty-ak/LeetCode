class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap();

        for(int i = 0, j = 0; i < s.length() && j < s.length(); j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(c, j);
        }

        return ans;
    }
}