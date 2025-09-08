class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];

        for(int i = 1; i <= n / 2; i++) {
            if(!hasZero(i) && !hasZero(n - i)) {
                ans[0] = i;
                ans[1] = n - i;
            }
        }

        return ans;
    }

    private boolean hasZero(int n) {
        return String.valueOf(n).indexOf('0') != -1;
    }
}