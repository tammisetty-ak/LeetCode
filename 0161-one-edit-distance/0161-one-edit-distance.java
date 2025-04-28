class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }
        
        if (m == n) {
            int diff = 0;
            for(int i = 0; i < m; i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    if(diff > 1) {
                        return false;
                    }
                    diff++;
                }
            }
            return diff == 1;
        }

        else {
            if (m > n) {
                return isOneInsertAlways(t, s);
            }
            else {
                return isOneInsertAlways(s, t);
            }
        }
    }

    private boolean isOneInsertAlways(String shorter, String longer) {

        int i = 0, j = 0;
        boolean found = false;
        while(i < shorter.length() && j < longer.length()) {
            if(shorter.charAt(i) != longer.charAt(j)) {
                if(found) {
                    return false;
                }
                found = true;
                j++;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }
}