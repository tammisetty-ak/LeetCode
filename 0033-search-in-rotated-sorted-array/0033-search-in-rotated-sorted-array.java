class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;


        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        int found = binarySearch(0, left - 1, nums, target);

        if(found != -1) {
            return found;
        }

        return binarySearch(left, nums.length - 1, nums, target);

    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}