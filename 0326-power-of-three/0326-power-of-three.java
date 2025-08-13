class Solution {
    public boolean isPowerOfThree(int n) {
        int[] dp = new int[31];
        dp[0] = 1;

        if(dp[0] == n) {
            return true;
        }

        for(int i = 1; i < 31; i++) {
            dp[i] = dp[i-1] * 3;
            if(dp[i] == n) {
                return true;
            }
        }

        return false;
    }

}