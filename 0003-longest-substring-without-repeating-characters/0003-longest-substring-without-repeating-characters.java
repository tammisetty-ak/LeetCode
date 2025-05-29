class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        int i = 0, j = 0;

        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
}