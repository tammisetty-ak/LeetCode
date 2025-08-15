class Solution {
    public boolean isPowerOfFour(int n) {
        double rem = n;
        while(rem % 10 == 4 || rem % 10 == 6) {
            rem = rem / 4;
        }
        return rem == 1.0 || rem == 4.0;
    }
}