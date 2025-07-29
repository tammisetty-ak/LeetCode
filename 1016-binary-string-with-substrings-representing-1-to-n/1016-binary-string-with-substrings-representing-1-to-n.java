class Solution {
    public boolean queryString(String s, int n) {
        for(int i = n; i >= 1; i--) {
            if(!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}