class Solution {
    public int maxPower(String s) {
        Character candidate = '\0';
        int maxPow = Integer.MIN_VALUE, count = 1;
        for(char c: s.toCharArray()) {
            if(c != candidate) {
                candidate = c;
                count = 1;
            }
            else {
                count++;
            }
            maxPow = Math.max(maxPow, count);
        }

        return maxPow;
    }
}