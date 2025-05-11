class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCountsS = charCounts(s);
        int[] charCountsT = charCounts(t);

        for(int i = 0; i < 26; i++) {
            if(charCountsS[i] != 0) {
                if(charCountsS[i] != charCountsT[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] charCounts(String s) {
        int[] charCounts = new int[26];
        for(char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        return charCounts;
    }
}