class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int ans = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = map.get(s.charAt(j)) + 1;
            } 
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;

    }
}

//abbc

//a - 0
// b - 1

// b - i-> 2, 0
//