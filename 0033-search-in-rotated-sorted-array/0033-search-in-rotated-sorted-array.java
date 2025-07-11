class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[n - 1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        int ans = binaryS(0, left, nums, target);
        if(ans != -1) {
            return ans;
        }
        return binaryS(left, n - 1, nums, target);
    }

    private int binaryS(int left, int right, int[] nums, int target) {
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}