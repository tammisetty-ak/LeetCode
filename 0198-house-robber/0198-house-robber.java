class Solution {
    public int rob(int[] nums) {
        int N = nums.length;

        int[] dp = new int[N + 2];

        for(int i = N - 1; i >= 0; --i) {
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }

        return dp[0];
    }
}