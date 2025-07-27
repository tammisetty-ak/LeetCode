class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        if(s.equals(goal)) {
            int[] freq = new int[26];
            for(char c : s.toCharArray()) {
                freq[c - 'a']++;
                if(freq[c - 'a'] == 2) {
                    return true;
                }
            }

            return false;
        }

        int firstIndex = -1;
        int secIndex = -1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(firstIndex == -1) {
                    firstIndex = i;
                }
                else if(secIndex == -1) {
                    secIndex = i;
                }
                else {
                    return false;
                }
            }
        }

        if(secIndex == -1) {
            return false;
        }

        return s.charAt(firstIndex) == goal.charAt(secIndex) && s.charAt(secIndex) == goal.charAt(firstIndex);
    }
}