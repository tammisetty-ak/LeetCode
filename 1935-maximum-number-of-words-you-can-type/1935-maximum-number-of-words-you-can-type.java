class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Store broken letters in a boolean array for O(1) lookup
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        int count = 0;
        for (String word : text.split(" ")) {
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) {
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }

        return count;
    }
}
