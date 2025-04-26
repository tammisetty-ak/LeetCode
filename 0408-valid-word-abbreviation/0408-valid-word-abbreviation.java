class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int w = 0, a = 0;

        while(w < word.length() && a < abbr.length()) {
            if(word.charAt(w) == abbr.charAt(a)) {
                w++; a++;
                continue;
            }

            if(abbr.charAt(a) <= '0' || abbr.charAt(a) > '9') {
                return false;
            }

            int start = a;

            while(a < abbr.length() && abbr.charAt(a) >= '0' && abbr.charAt(a) <= '9') {
                ++a;
            }

            int num = Integer.valueOf(abbr.substring(start, a));
            w += num;
        }

        return w == word.length() && a == abbr.length();
    }
}