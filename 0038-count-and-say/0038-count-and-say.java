class Solution {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        if(n == 1) {
            return s.toString();
        }
        while(n != 1) {
            StringBuilder str = new StringBuilder();
            char ch = s.charAt(0);
            int count = 0;
            for(int i = 0; i < s.length(); i++) {
                if(ch == s.charAt(i)) {
                    count++;
                }
                else {
                    str.append(count);
                    str.append(ch);
                    ch = s.charAt(i);
                    count = 1;
                }
            }
            str.append(count).append(ch);
            s = str;
            n--;
        }
        return s.toString();
    }
}