class Solution {
    public String betterCompression(String compressed) {
        int[] chars = new int[26];
        char store = '\0';
        int val = 0;

        for(char c: compressed.toCharArray()) {
            if(!Character.isDigit(c)) {
                if(store != '\0')
                    chars[store - 'a'] += val;
                store = c;
                val = 0;
            }
            else {
                val = val * 10 + (c - '0');
            }
        }

        chars[store - 'a'] += val;

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(chars[i] != 0) {
                res.append((char)(i + 'a')).append(chars[i]);
            }
        }

        return res.toString();
    }
}

// a3c9b2c1

// a 

// if(!Char.isDig(c)) -> store - a -> chars[a] += val store -> c
// else 0 * 10 + 3 -> 3 // -