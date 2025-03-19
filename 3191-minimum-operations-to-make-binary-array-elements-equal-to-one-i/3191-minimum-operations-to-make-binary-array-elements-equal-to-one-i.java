class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n - 2; i++) {
            if(nums[i] == 0 ) {
                toggle(nums, i);
                count++;
            }
        }
        
        int sum = 0;

        for(int num: nums) sum += num;
        return (sum == n) ? count : -1;
    }

    private void toggle(int[] nums, int i) {
        nums[i] = 1;
        nums[i + 1] = 1 - nums[i + 1];
        nums[i + 2] = 1 - nums[i + 2];
    }
}