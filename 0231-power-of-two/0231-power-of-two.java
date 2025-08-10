class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        for(int i = 2; i < n; i = i * 2) {
            if(n % i != 0) {
                return false;
            }
        }
        return true;
    }
}