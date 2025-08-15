class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;

        int[] dp = new int[n];

        if(nums[0] <= threshold && nums[0] % 2 == 0) {
            dp[0] = 1;
        }
        else {
            dp[0] = 0;
        }
        int max = dp[0];

        for(int i = 1; i < n; i++) {
            if(nums[i] <= threshold) {
                if(dp[i - 1] > 0 && nums[i] % 2 != nums[i - 1] % 2) {
                    dp[i] = 1 + dp[i - 1];
                }
                else if(nums[i] % 2 == 0) {
                    dp[i] = 1;
                }
                else {
                    dp[i] = 0;
                }
            }
            else {
                dp[i] = 0;
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}