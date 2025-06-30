class Solution {
    int[] res;

    private void binarySearch(int[] nums, int target, boolean isFirst) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if(isFirst) {
                    res[0] = mid;
                    high = mid - 1;
                }
                else {
                    res[1] = mid;
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        res = new int[]{-1, -1};
        binarySearch(nums, target, true);

        if(res[0] == -1) {
            return new int[] {-1, -1};
        }
        else {
            binarySearch(nums, target, false);
        }

        return res;
    }
}