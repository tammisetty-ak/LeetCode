class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        }
        while(n % 3 == 0) {
            n = n / 3;
            if(n == 3) {
                break;
            }
        }
        return n == 1 || n == 3;
    }
}