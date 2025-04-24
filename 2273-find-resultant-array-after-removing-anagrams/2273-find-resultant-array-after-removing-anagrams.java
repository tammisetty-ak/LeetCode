import java.util.Collection;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> seen = new Stack<>();
        List<String> res = new ArrayList<>();

        for(String word: words) {
            int[] charCount = new int[26];

            for(char c: word.toCharArray()) {
                charCount[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 26; i++) {
                while(charCount[i]-- > 0) {
                    sb.append(i + 'a');
                }
            }
            if(seen.isEmpty() || !seen.peek().equals(sb.toString())) {
                    seen.push(sb.toString());
                    res.add(word);
                }
        }

        // Collection<String> temp = map.values();

        return res;
    }
}