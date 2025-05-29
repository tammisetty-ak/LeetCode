class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap();

        for(char ct : t.toCharArray()) {
            mapT.put(ct, mapT.getOrDefault(ct, 0) + 1);
        }

        int req = mapT.size();
        Map<Character, Integer> windowMap = new HashMap();
        int l = 0, r = 0;
        int formed = 0;

        int[] ans = {-1, 0, 0};

        while(r < s.length()) {
            char c = s.charAt(r);
            int count = windowMap.getOrDefault(c, 0);
            windowMap.put(c, count + 1);

            if(mapT.containsKey(c) && mapT.get(c).intValue() == windowMap.get(c).intValue()) {
                formed++;
            }

            while(l <= r && formed == req) {
                c = s.charAt(l);
                if(ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowMap.put(c, windowMap.get(c) - 1);
                if(mapT.containsKey(c) && windowMap.get(c).intValue() < mapT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}