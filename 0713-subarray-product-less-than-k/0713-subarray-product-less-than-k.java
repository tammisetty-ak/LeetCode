class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }
        int left = 0;
        int product = 1;
        int total = 0;
        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while(product >= k ) {
                product = product / nums[left++];
            }
            total += right - left + 1;
        }

        return total;
    }
}
