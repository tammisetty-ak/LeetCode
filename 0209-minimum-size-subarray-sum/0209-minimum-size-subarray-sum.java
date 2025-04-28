class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}