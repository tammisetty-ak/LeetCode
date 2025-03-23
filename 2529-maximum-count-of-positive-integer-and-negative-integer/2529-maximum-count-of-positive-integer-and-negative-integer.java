class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int low = 0, high = n;
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] < 0) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        int negCount = low;
        low = 0;
        high = n;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= 0) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        int posCount = n - low;

        return Math.max(negCount, posCount);


    }
}