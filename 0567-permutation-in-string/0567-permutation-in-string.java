class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap();

        for(int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> s2Map = new HashMap();

        for(int i = 0; i < s2.length(); i++) {
            char rightChar = s2.charAt(i);
            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);

            if(i >= s1.length()) {
                char leftChar = s2.charAt(i - s1.length());

                if(s2Map.get(leftChar) == 1) {
                    s2Map.remove(leftChar);
                }
                else {
                    s2Map.put(leftChar, s2Map.get(leftChar) - 1);
                }
            }

            if(s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }
}