class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];

        int left = 0; 

        int maxSum = sum;

        for(int right = 1; right < nums.length; right++) {
            
            if(sum < 0) {
                sum = nums[right];
                left = right;
            }
            else {
                sum += nums[right];
                // left++;
            }
            maxSum = Math.max(sum, maxSum);
        }

        return nums.length == 1 ? sum : maxSum;
    }
}