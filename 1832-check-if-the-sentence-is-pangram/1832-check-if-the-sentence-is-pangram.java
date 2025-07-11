class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] chars = new int[26];
        for(char c: sentence.toCharArray()) {
            chars[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(chars[i] < 1) {
                return false;
            }
        }
        return true;
    }
}