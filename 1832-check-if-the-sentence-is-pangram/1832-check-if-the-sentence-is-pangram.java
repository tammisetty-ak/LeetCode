class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] chars = new int[26];

        for(char c: sentence.toCharArray()) {
            chars[c - 'a']++;
        }

        for(int i: chars) {
            if(i < 1) {
                return false;
            }
        }
        return true;
    }
}