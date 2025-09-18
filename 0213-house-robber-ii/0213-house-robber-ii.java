class Solution {

    private int findMaxRobbedAmount(int[] nums, int start, int end) {
        // Calculate the number of houses in the subarray
        int n = end - start;
        // Create dp array with extra space to avoid index out-of-bound checks
        int[] dp = new int[n + 2];
        
        // Fill dp array from the end of the subarray
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[start + i]);
        }
        return dp[0];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // Compute the maximum robbed amount by excluding the last house and excluding the first house
        return Math.max(
            findMaxRobbedAmount(nums, 0, n - 1),  // Consider houses 0 to n-2
            findMaxRobbedAmount(nums, 1, n)       // Consider houses 1 to n-1
        );
    }
}
