class Solution {

    int count = 0;

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            twoSumII(nums, i, target);
        }

        return count;
    }

    public void twoSumII(int nums[], int i, int target) {
        int low = i + 1, high = nums.length - 1;

        while(low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if(sum < target) {
                count += high - low;
                low++;
            }
            else {
                high--;
            }
        }
    }
}