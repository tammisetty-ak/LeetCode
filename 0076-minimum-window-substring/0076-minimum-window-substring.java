class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap();
        for(char c: t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int required = mapT.size();
        int formed = 0;
        int left = 0, right = 0;
        Map<Character, Integer> windowMap = new HashMap();
        int[] ans = {-1, 0, 0};

        while(right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if(mapT.containsKey(c) && mapT.get(c) == windowMap.get(c)) {
                formed++;


                while(left <= right && formed == required) {
                    if(ans[0] == -1 || right - left + 1 < ans[0]) {
                        ans[0] = right - left + 1;
                        ans[1] = left;
                        ans[2] = right;
                    }
                    int count = windowMap.get(s.charAt(left));

                    windowMap.put(s.charAt(left), count - 1);
                    if(mapT.containsKey(s.charAt(left)) && windowMap.get(s.charAt(left)) < mapT.get(s.charAt(left))) {
                        formed--;
                    }
                    left++;
                }
            }
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}