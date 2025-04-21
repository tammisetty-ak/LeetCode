class Solution {
    int diff = Integer.MAX_VALUE;


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && diff != 0; i++) {
            twoSumII(nums, i, target);
        }

        return target - diff;
    }

    public void twoSumII(int nums[], int i, int target) {
        int low = i + 1, high = nums.length - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if(Math.abs(target-sum) < Math.abs(diff)) {
                diff = target - sum;
            }

            if (sum > target) {
                high--;
            }
            
            else {
                low++;
            }
        }
    }
}