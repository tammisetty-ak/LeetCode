class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        long windowSum = 0;
        int result = 1;

        for(int right = 0; right < n; right++) {
            windowSum += nums[right];

            while((long)nums[right] * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            } 
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}