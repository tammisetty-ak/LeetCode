class Solution {
    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                min = Math.min(nums[i], min);
            }
        }

        return min == Integer.MAX_VALUE ? nums[0] : min;
    }
}