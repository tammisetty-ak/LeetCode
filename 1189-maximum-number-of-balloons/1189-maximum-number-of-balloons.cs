public class Solution {
    public int MaxNumberOfBalloons(string text) {
        int[] chars = new int[26];
        

        foreach(char c in text) {
            chars[c - 'a']++;
        }

        int count = text.Length;

        for(int i = 0; i < 26; i++) {
            if((i + 'a') == 'l' || (i + 'a') == 'o') {
                chars[i] = chars[i] / 2;
            }
            if((i + 'a') == 'b' || (i + 'a') == 'a' || (i + 'a') == 'l' || (i + 'a') == 'o' || (i + 'a') == 'n') {
                count = Math.Min(count, chars[i]);
            }
        }
        return count;
    }
}